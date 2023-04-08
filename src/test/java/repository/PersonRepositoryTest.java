package repository;

import domain.Address;
import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    //TODO 6d Voer het insert-person.sql script uit
    // haal de code uit commentaar en run de tet. Deze moet slagen
    @Test
    void shouldReadPerson() {
        Person person = repository.readPerson(1);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Frank");
        assertThat(person.getLastName()).isEqualTo("Rinkens");
        assertThat(person.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(person.getGender()).isEqualTo(Gender.MALE);

//        Address address = person.getAddress();
//        assertThat(address.getStreetName()).isEqualTo("Dolphijnstraat");
//        assertThat(address.getHouseNumber()).isEqualTo("10");
//        assertThat(address.getZipCode()).isEqualTo("5632CZ");
//        assertThat(address.getCity()).isEqualTo("Eindhoven");
//        assertThat(address.getCountry()).isEqualTo("Nederland");
    }

    //TODO 6c haal de code uit commentaar en run de tet. Deze moet slagen
    @Test
    void shouldCreatePerson() {
        Address address = new Address("Frederik Hendrikstraat", "7", "4141JD", "Leerdam", "Nederland");
        Person person = new Person(2, "Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        //person.setAddress(address);
        repository.createPerson(person);

        Person createdPerson = repository.readPerson(2);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Rick");
        assertThat(createdPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);

        //Address createdAddress = person.getAddress();
        //assertThat(createdAddress).isNotNull();
        //assertThat(createdAddress.getStreetName()).isEqualTo("Frederik Hendrikstraat");
        //assertThat(createdAddress.getHouseNumber()).isEqualTo("7");
        //assertThat(createdAddress.getZipCode()).isEqualTo("4141JD");
        //assertThat(createdAddress.getCity()).isEqualTo("Leerdam");
        //assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
    }

    @Test
    void shouldUpdate() {
        String firstName = "Willy";
        repository.updateFirstName(firstName, 2);
        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
    }

    @Test
    void shouldDelete() {
        repository.deletePerson(2);
        Person deletedPerson = repository.readPerson(2);
        assertThat(deletedPerson).isNull();
    }
}