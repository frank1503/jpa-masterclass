package repository;

import domain.Address;
import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    //TODO 3c test moet nu slagen
    @Test
    void shouldReadPerson() throws SQLException {
        Person person = repository.readPerson(1);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Frank");
        assertThat(person.getLastName()).isEqualTo("Rinkens");
        assertThat(person.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(person.getGender()).isEqualTo(Gender.MALE);

        Address address = person.getAddress();
        assertThat(address.getStreetName()).isEqualTo("Dolphijnstraat");
        assertThat(address.getHouseNumber()).isEqualTo("10");
        assertThat(address.getZipCode()).isEqualTo("5632CZ");
        assertThat(address.getCity()).isEqualTo("Eindhoven");
        assertThat(address.getCountry()).isEqualTo("Nederland");
    }

    //TODO 3g test moet nu slagen
    @Test
    void shouldCreatePerson() throws SQLException {
        Address address = new Address("Dorpstraat", "1a", "5504HK", "Veldhoven", "Nederland");
        Person person = new Person(3, "Gerda", "Janssen", LocalDate.parse("1974-08-29"), Gender.FEMALE, address);
        repository.createPerson(person);
        Person createdPerson = repository.readPerson(3);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Gerda");
        assertThat(createdPerson.getLastName()).isEqualTo("Janssen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1974-08-29"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.FEMALE);

        Address createdAddress = person.getAddress();
        assertThat(createdAddress.getStreetName()).isEqualTo("Dorpstraat");
        assertThat(createdAddress.getHouseNumber()).isEqualTo("1a");
        assertThat(createdAddress.getZipCode()).isEqualTo("5504HK");
        assertThat(createdAddress.getCity()).isEqualTo("Veldhoven");
        assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
    }

    //TODO 3k test moet nu slagen
    @Test
    void shouldUpdateAddress() throws SQLException {
        Address address = new Address("Keizerstraat", "11", "5751MR", "Deurne", "Nederland");
        repository.updateAddress(address, 3);
        Person person = repository.readPerson(3);

        Address updatedAddress = person.getAddress();
        assertThat(updatedAddress).isNotNull();
        assertThat(updatedAddress.getStreetName()).isEqualTo("Keizerstraat");
        assertThat(updatedAddress.getHouseNumber()).isEqualTo("11");
        assertThat(updatedAddress.getZipCode()).isEqualTo("5751MR");
        assertThat(updatedAddress.getCity()).isEqualTo("Deurne");
        assertThat(updatedAddress.getCountry()).isEqualTo("Nederland");
    }

    @Test
    void shouldUpdate() throws SQLException {
        String firstName = "Willy";
        repository.updateFirstName(firstName, 2);
        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Johnson");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1990-04-26"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
    }

    @Test
    void shouldDelete() throws SQLException {
        repository.deletePerson(1);
        Person deletedPerson = repository.readPerson(1);
        assertThat(deletedPerson).isNull();
    }
}