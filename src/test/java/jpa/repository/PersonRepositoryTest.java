package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
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

    //TODO 11l haal de code uit commentaar en draai de test. deze moet slagen
    @Test
    void shouldCreateAndReadPerson() {
//        SportsClub soccerClub = new SportsClub("FC De Treffers");
//        SportsClub tennisClub = new SportsClub("TC De Aces");
//        Insurance carInsurance = new Insurance("Car", new BigDecimal("85.99"));
//        Insurance houseInsurance = new Insurance("House", new BigDecimal("105.99"));
//        Car car = new Car(1, "P-468-LJ", "Seat", "Blue");
//        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
//        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
//
//        person.setAddress(address);
//        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
//        person.setCar(car);
//
//        car.setPerson(person);
//
//        person.addInsurance(carInsurance);
//        person.addInsurance(houseInsurance);
//
//        person.addSportsClub(soccerClub);
//        person.addSportsClub(tennisClub);
//
//        personRepository.createPerson(person);
//        entityManager.flush();
//        entityManager.clear();
//
//        Person createdPerson = personRepository.readPerson(person.getId());
//        assertThat(createdPerson).isNotNull();
//        assertThat(createdPerson.getFirstName()).isEqualTo("Rick");
//        assertThat(createdPerson.getLastName()).isEqualTo("Roelofsen");
//        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
//        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
//        assertThat(createdPerson.getTelephoneNumbers()).hasSize(2).contains("0629731948", "0645859845");
//        assertThat(createdPerson.getAge()).isEqualTo(39);
//        assertThat(createdPerson.getInsurances()).hasSize(2)
//                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id", "person")
//                .contains(carInsurance, houseInsurance);
//        assertThat(createdPerson.getSportsClubs()).hasSize(2)
//                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id", "members")
//                .contains(soccerClub, tennisClub);
//
//        Address createdAddress = person.getAddress();
//        assertThat(createdAddress).isNotNull();
//        assertThat(createdAddress.getStreetName()).isEqualTo("Frederik Hendrikstraat");
//        assertThat(createdAddress.getHouseNumber()).isEqualTo("7");
//        assertThat(createdAddress.getZipCode()).isEqualTo("4141JD");
//        assertThat(createdAddress.getCity()).isEqualTo("Leerdam");
//        assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
//
//        Car createdCar = person.getCar();
//        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");
//        assertThat(createdCar.getSequenceNumber()).isEqualTo(1);
//        assertThat(createdCar.getBrand()).isEqualTo("Seat");
//        assertThat(createdCar.getColor()).isEqualTo("Blue");
    }

    //TODO 11m haal de code uit commentaar en draai de test. deze moet slagen
    @Test
    void shouldDeletePerson() {
//        Insurance carInsurance = new Insurance("Car", new BigDecimal("85.99"));
//        Insurance houseInsurance = new Insurance("House", new BigDecimal("105.99"));
//        Car car = new Car(1, "Seat", "Blue", "P-468-LJ");
//        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
//        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
//        person.setAddress(address);
//        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
//        person.setCar(car);
//        car.setPerson(person);
//        carInsurance.setPerson(person);
//        houseInsurance.setPerson(person);
//        //person.setInsurances(List.of(carInsurance, houseInsurance));
//
//        int id = personRepository.createPerson(person);
//        entityManager.flush();
//        entityManager.clear();
//
//        personRepository.deletePerson(id);
//        entityManager.flush();
//        entityManager.clear();
//
//        Person deletedPerson = personRepository.readPerson(id);
//        assertThat(deletedPerson).isNull();
//
//        Car carNotFound = entityManager.find(Car.class, new CarPK(1, "P-468-LJ"));
//        assertThat(carNotFound).isNull();

//        Insurance carInsuranceNotFound = entityManager.find(Insurance.class, person.getInsurances().get(0).getId());
//        assertThat(carInsuranceNotFound).isNull();
//        Insurance houseInsuranceNotFound = entityManager.find(Insurance.class, person.getInsurances().get(1).getId());
//        assertThat(houseInsuranceNotFound).isNull();
    }

    @Test
    void shouldAlsoDeleteCarWhenSetToNull() {
        Car car = new Car(1, "Seat", "Blue", "P-468-LJ");
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        person.setCar(car);
        car.setPerson(person);
        int id = personRepository.createPerson(person);
        entityManager.flush();
        entityManager.clear();

        Person createdPerson = personRepository.readPerson(id);
        createdPerson.setCar(null);

        personRepository.deletePerson(id);
        entityManager.flush();
        entityManager.clear();

        Person deletedPerson = personRepository.readPerson(id);
        assertThat(deletedPerson).isNull();

        Car carNotFound = entityManager.find(Car.class, new CarPK(1, "P-468-LJ"));
        assertThat(carNotFound).isNull();
    }
}