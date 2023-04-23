package jpa.repository;

import jakarta.persistence.EntityManager;
import jpa.JpaApplication;
import jpa.domain.Address;
import jpa.domain.Gender;
import jpa.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    void shouldCreateAndReadPerson() {
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
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
    }

    @Test
    void shouldUpdatePerson() {
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        int id = personRepository.createPerson(person);
        entityManager.flush();
        entityManager.clear();

        address = new Address("Dorpstraat", "1a", "5504HK", "Veldhoven", "Nederland");
        person.setFirstName("Willy");
        person.setAddress(address);
        person.setTelephoneNumbers(List.of("0629731948", "0698746325"));
        person.setId(id);
        personRepository.updatePerson(person);
        entityManager.flush();
        entityManager.clear();

        Person updatedPerson = personRepository.readPerson(id);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
        assertThat(updatedPerson.getTelephoneNumbers()).hasSize(2).contains("0629731948", "0698746325");
        assertThat(updatedPerson.getAge()).isEqualTo(37);

        Address createdAddress = updatedPerson.getAddress();
        assertThat(createdAddress).isNotNull();
        assertThat(createdAddress.getStreetName()).isEqualTo("Dorpstraat");
        assertThat(createdAddress.getHouseNumber()).isEqualTo("1a");
        assertThat(createdAddress.getZipCode()).isEqualTo("5504HK");
        assertThat(createdAddress.getCity()).isEqualTo("Veldhoven");
        assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
    }

    @Test
    void shouldDeletePerson() {
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        person.setAddress(address);
        int id = personRepository.createPerson(person);
        entityManager.flush();
        entityManager.clear();

        personRepository.deletePerson(id);
        entityManager.flush();
        entityManager.clear();

        Person deletedPerson = personRepository.readPerson(id);
        assertThat(deletedPerson).isNull();
    }
}