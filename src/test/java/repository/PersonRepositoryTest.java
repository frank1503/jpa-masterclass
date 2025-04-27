package repository;

import domain.Address;
import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    @Test
    void shouldCreateAndReadPerson() {
        List<String> telephoneNumbers = List.of("0629731948", "0645859845");
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person(2, "John", "Johnson", LocalDate.parse("1990-04-26"), Gender.MALE, telephoneNumbers);
        person.setAddress(address);
        repository.createPerson(person);

        Person createdPerson = repository.readPerson(2);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("John");
        assertThat(createdPerson.getLastName()).isEqualTo("Johnson");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1990-04-26"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
        assertThat(createdPerson.getTelephoneNumbers()).hasSize(2).contains("0629731948", "0645859845");

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
        List<String> telephoneNumbers = List.of("0629731948", "0645859845");
        Address address = new Address("Dorpstraat", "1a", "5504HK", "Veldhoven", "Nederland");
        Person person = new Person(2, "Willy", "Johnson", LocalDate.parse("1990-04-26"), Gender.MALE, telephoneNumbers);
        person.setAddress(address);
        repository.updatePerson(person);

        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Johnson");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1990-04-26"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
        assertThat(updatedPerson.getTelephoneNumbers()).hasSize(2).contains("0629731948", "0645859845");

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
        repository.deletePerson(2);
        Person deletedPerson = repository.readPerson(2);
        assertThat(deletedPerson).isNull();
    }
}