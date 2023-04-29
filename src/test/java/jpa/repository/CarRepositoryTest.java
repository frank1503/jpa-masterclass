package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.Car;
import jpa.domain.CarPK;
import jpa.domain.Gender;
import jpa.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
@Sql("/db_setup.sql")
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldAddAndReadCar() {
        Car car = new Car(1, "P-468-LJ", "Seat", "Blue");
        CarPK carPK = carRepository.createCar(car);
        Person person = new Person("Frank", "Rinkens", LocalDate.parse("1986-03-15"), Gender.MALE);
        car.setPerson(person);
        person.setCar(car);
        entityManager.flush();
        entityManager.clear();

        Car createdCar = carRepository.readCar(carPK);
        assertThat(createdCar.getSequenceNumber()).isEqualTo(1);
        assertThat(createdCar.getBrand()).isEqualTo("Seat");
        assertThat(createdCar.getColor()).isEqualTo("Blue");
        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");

        Person createdPerson = createdCar.getPerson();
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Frank");
        assertThat(createdPerson.getAge()).isEqualTo(37);
    }

    @Test
    void shouldDeleteCar() {
        Car car = new Car(1, "P-468-LJ", "Seat", "Blue");
        CarPK carPK = carRepository.createCar(car);
        Person person = new Person("Frank", "Rinkens", LocalDate.parse("1986-03-15"), Gender.MALE);
        car.setPerson(person);
        person.setCar(car);
        entityManager.flush();
        entityManager.clear();

        carRepository.deleteCar(carPK);
        entityManager.flush();
        entityManager.clear();

        Car deletedCar = carRepository.readCar(carPK);
        assertThat(deletedCar).isNull();

        person = entityManager.find(Person.class, person.getId());
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Frank");
        assertThat(person.getCar()).isNull();
    }
}
