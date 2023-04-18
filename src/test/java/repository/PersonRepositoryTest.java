package repository;

import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();

    //TODO 1c draai de untit test. Deze zal nu slagen
    @Test
    void shouldReadPerson() throws SQLException {
        Person person = repository.readPerson(1);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Frank");
        assertThat(person.getLastName()).isEqualTo("Rinkens");
        assertThat(person.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(person.getGender()).isEqualTo(Gender.MALE);
    }
}