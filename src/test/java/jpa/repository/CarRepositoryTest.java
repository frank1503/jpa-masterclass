package jpa.repository;

import jakarta.persistence.EntityManager;
import jpa.JpaApplication;
import jpa.domain.Car;
import jpa.domain.CarPK;
import jpa.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
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

    //TODO 10f haal de code uit commentaar en draai de unit test. Deze moeten slagen
    @Sql({"/car_setup.sql"})
    @Test
    void shouldReadCar() {
//        CarPK carPK = new CarPK(1, "P-468-LJ");
//
//        Car createdCar = carRepository.readCar(carPK);
//        assertThat(createdCar.getSequenceNumber()).isEqualTo(1);
//        assertThat(createdCar.getBrand()).isEqualTo("Seat");
//        assertThat(createdCar.getColor()).isEqualTo("Blue");
//        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");
//
//        Person createdPerson = createdCar.getPerson();
//        assertThat(createdPerson).isNotNull();
//        assertThat(createdPerson.getFirstName()).isEqualTo("Frank");
//        assertThat(createdPerson.getTelephoneNumbers()).hasSize(2);
//        assertThat(createdPerson.getAge()).isEqualTo(39);
    }

    //TODO 10g haal de code uit commentaar en draai de unit test. Deze moeten slagen
    @Sql({"/car_setup.sql"})
    @Test
    void shouldDeleteCar() {
//        CarPK carPK = new CarPK(1, "P-468-LJ");
//
//        carRepository.deleteCar(carPK);
//        entityManager.flush();
//        entityManager.clear();
//
//        Car deletedCar = carRepository.readCar(carPK);
//        assertThat(deletedCar).isNull();
//
//        Person person = entityManager.find(Person.class, 1);
//        assertThat(person).isNotNull();
//        assertThat(person.getFirstName()).isEqualTo("Frank");
//        assertThat(person.getCar()).isNull();
    }
}
