package jpa.repository;

import jakarta.persistence.EntityManager;
import jpa.JpaApplication;
import jpa.domain.Car;
import jpa.domain.CarPK;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Disabled
    void shouldCreateReadAndDeleteCar() {
        Car car = new Car(123, "Seat", "Blue", "P-468-LJ");
        CarPK carPK = carRepository.createCar(car);
        entityManager.flush();
        entityManager.clear();

        Car createdCar = carRepository.readCar(carPK);
        assertThat(createdCar.getSequenceNumber()).isEqualTo(123);
        assertThat(createdCar.getBrand()).isEqualTo("Seat");
        assertThat(createdCar.getColor()).isEqualTo("Blue");
        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");

        carRepository.deleteCar(carPK);
        entityManager.flush();
        entityManager.clear();

        Car deletedCar = carRepository.readCar(carPK);
        assertThat(deletedCar).isNull();
    }

    @Test
    void shouldReadCar() {
        Car car = new Car(123, "Seat", "Blue", "P-468-LJ");
        entityManager.persist(car);
        entityManager.flush();
        entityManager.clear();

        Car foundCar = carRepository.readCar(new CarPK(car.getSequenceNumber(), car.getRegistrationPlate()));
        assertThat(foundCar).isNotNull();
        assertThat(foundCar). usingRecursiveComparison().isEqualTo(car);
    }

    @Test
    void shouldCreateCar() {
        Car car = new Car(123, "Seat", "Blue", "P-468-LJ");
        CarPK carPK = carRepository.createCar(car);
        entityManager.flush();
        entityManager.clear();

        Car createdCar = entityManager.find(Car.class, carPK);
        assertThat(createdCar).isNotNull();
        assertThat(createdCar). usingRecursiveComparison().isEqualTo(car);
    }

    @Test
    void shouldDeleteCar() {
        Car car = new Car(123, "Seat", "Blue", "P-468-LJ");
        entityManager.persist(car);
        entityManager.flush();
        entityManager.clear();

        CarPK carPK = new CarPK(car.getSequenceNumber(), car.getRegistrationPlate());
        carRepository.deleteCar(carPK);
        entityManager.flush();
        entityManager.clear();

        Car deletedCar = entityManager.find(Car.class, carPK);
        assertThat(deletedCar).isNull();
    }
}
