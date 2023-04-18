package repository;

import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    @Test
    void shouldReadPerson() throws SQLException {
        Person person = repository.readPerson(1);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Frank");
        assertThat(person.getLastName()).isEqualTo("Rinkens");
        assertThat(person.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(person.getGender()).isEqualTo(Gender.MALE);
    }

    //TODO 2c De test moet nu slagen
    @Test
    void shouldCreatePerson() throws SQLException {
        Person person = new Person(2, "Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        repository.createPerson(person);
        Person createdPerson = repository.readPerson(2);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Rick");
        assertThat(createdPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
    }

    //TODO 2g De test moet nu slagen
    @Test
    void shouldUpdate() throws SQLException {
        String firstName = "Willy";
        repository.updateFirstName(firstName, 2);
        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
    }

    //TODO 2k De test moet nu slagen
    @Test
    void shouldDelete() throws SQLException {
        repository.deletePerson(1);
        Person deletedPerson = repository.readPerson(1);
        assertThat(deletedPerson).isNull();
    }
}