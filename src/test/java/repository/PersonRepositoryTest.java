package repository;

import domain.Address;
import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    //TODO 6d haal de code uit commentaar en run de tet. Deze moet slagen
    @Test
    void shouldCreateAndReadPerson() {
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person(2, "Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        //person.setAddress(address);
        //person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        repository.createPerson(person);

        Person createdPerson = repository.readPerson(2);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Rick");
        assertThat(createdPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
        //assertThat(createdPerson.getTelephoneNumbers()).hasSize(2),contains("0629731948", "0645859845");

        //Address createdAddress = person.getAddress();
        //assertThat(createdAddress).isNotNull();
        //assertThat(createdAddress.getStreetName()).isEqualTo("Frederik Hendrikstraat");
        //assertThat(createdAddress.getHouseNumber()).isEqualTo("7");
        //assertThat(createdAddress.getZipCode()).isEqualTo("4141JD");
        //assertThat(createdAddress.getCity()).isEqualTo("Leerdam");
        //assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
    }

    //TODO 6e haal de code uit commentaar en run de tet. Deze moet slagen
    @Test
    void shouldUpdatePerson() {
        Address address = new Address("Dorpstraat", "1a", "5504HK", "Veldhoven", "Nederland");
        Person person = new Person(2, "Willy", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        //person.setAddress(address);
        //person.setTelephoneNumbers(List.of("0629731948", "0645859845"));
        repository.updatePerson(person);

        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
        //assertThat(createdPerson.getTelephoneNumbers()).hasSize(2),contains("0629731948", "0645859845");

        //Address createdAddress = updatedPerson.getAddress();
        //assertThat(createdAddress).isNotNull();
        //assertThat(createdAddress.getStreetName()).isEqualTo("Dorpstraat");
        //assertThat(createdAddress.getHouseNumber()).isEqualTo("1a");
        //assertThat(createdAddress.getZipCode()).isEqualTo("5504HK");
        //assertThat(createdAddress.getCity()).isEqualTo("Veldhoven");
        //assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
    }

    //TODO 6f Run de tet. Deze moet slagen
    @Test
    void shouldDeletePerson() {
        repository.deletePerson(2);
        Person deletedPerson = repository.readPerson(2);
        assertThat(deletedPerson).isNull();
    }
}