package jpa.repository;

import jakarta.persistence.EntityManager;
import jpa.JpaApplication;
import jpa.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EntityManager entityManager;

    //TODO 10b haal de code uit commentaar en draai de unit test. Deze moeten slagen
    @Sql({"/person_setup.sql"})
    @Test
    void shouldCreateAndReadPerson() {
        Car car = new Car(1, "Seat", "Blue", "P-468-LJ");
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        //person.setCar(car);
        int id = personRepository.createPerson(person);
        entityManager.flush();
        entityManager.clear();

        Person createdPerson = personRepository.readPerson(id);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Rick");
        assertThat(createdPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
        assertThat(createdPerson.getTelephoneNumbers()).hasSize(2).contains("0629731948", "0645859845");
        assertThat(createdPerson.getAge()).isEqualTo(37);

        Address createdAddress = person.getAddress();
        assertThat(createdAddress).isNotNull();
        assertThat(createdAddress.getStreetName()).isEqualTo("Frederik Hendrikstraat");
        assertThat(createdAddress.getHouseNumber()).isEqualTo("7");
        assertThat(createdAddress.getZipCode()).isEqualTo("4141JD");
        assertThat(createdAddress.getCity()).isEqualTo("Leerdam");
        assertThat(createdAddress.getCountry()).isEqualTo("Nederland");

//        Car createdCar = person.getCar();
//        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");
//        assertThat(createdCar.getSequenceNumber()).isEqualTo(1);
//        assertThat(createdCar.getBrand()).isEqualTo("Seat");
//        assertThat(createdCar.getColor()).isEqualTo("Blue");
    }

    //TODO 10c haal de code uit commentaar en draai de unit test. Deze moeten slagen
    @Sql({"/person_setup.sql"})
    @Test
    void shouldDeletePerson() {
        Car car = new Car(1, "Seat", "Blue", "P-468-LJ");
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        //person.setCar(car);
        //car.setPerson(person);
        int id = personRepository.createPerson(person);
        entityManager.flush();
        entityManager.clear();

        personRepository.deletePerson(id);
        entityManager.flush();
        entityManager.clear();

        Person deletedPerson = personRepository.readPerson(id);
        assertThat(deletedPerson).isNull();

        Car carNotFound = entityManager.find(Car.class, new CarPK(1, "P-468-LJ"));
        assertThat(carNotFound).isNull();
    }

    //TODO 10d haal de code uit commentaar en draai de unit test. Deze moeten slagen
    @Sql({"/person_setup.sql"})
    @Test
    void shouldAlsoDeleteCarWhenSetToNull() {
        Car car = new Car(1, "Seat", "Blue", "P-468-LJ");
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        //person.setCar(car);
        //car.setPerson(person);
        int id = personRepository.createPerson(person);
        entityManager.flush();
        entityManager.clear();

        Person createdPerson = personRepository.readPerson(id);
        //createdPerson.setCar(null);

        personRepository.deletePerson(id);
        entityManager.flush();
        entityManager.clear();

        Person deletedPerson = personRepository.readPerson(id);
        assertThat(deletedPerson).isNull();

        Car carNotFound = entityManager.find(Car.class, new CarPK(1, "P-468-LJ"));
        assertThat(carNotFound).isNull();
    }
}