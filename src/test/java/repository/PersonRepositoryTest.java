package repository;

import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    @Test
    void shouldCreateAndReadPerson() {
        Person person = new Person(2, "John", "Johnson", LocalDate.parse("1990-04-26"), Gender.MALE);
        repository.createPerson(person);
        Person createdPerson = repository.readPerson(2);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("John");
        assertThat(createdPerson.getLastName()).isEqualTo("Johnson");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1990-04-26"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);
    }

    @Test
    void shouldUpdatePerson() {
        Person person = new Person(2, "Willy", "Johnson", LocalDate.parse("1990-04-26"), Gender.MALE);
        repository.updatePerson(person);
        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Johnson");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1990-04-26"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
    }

    @Test
    void shouldDelete() {
        repository.deletePerson(2);
        Person deletedPerson = repository.readPerson(2);
        assertThat(deletedPerson).isNull();
    }
}