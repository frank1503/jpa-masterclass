package repository;

import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    @Test
    void shouldCreateAndReadPerson() {
        Person person = new Person(2, "Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        repository.createPerson(person);
        Person createdPerson = repository.readPerson(2);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Rick");
        assertThat(createdPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
    }

    @Test
    void shouldUpdatePerson() {
        Person person = new Person(2, "Willy", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        repository.updatePerson(person);
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