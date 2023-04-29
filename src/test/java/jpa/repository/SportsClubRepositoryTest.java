package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.Person;
import jpa.domain.SportsClub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
@Sql("/db_setup.sql")
public class SportsClubRepositoryTest {

    @Autowired
    private SportsClubRepository sportsClubRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldAddSportsClub() {
        SportsClub ajax = new SportsClub("Ajax");
        Person person1 = createPerson("Dusan", "Tadic");
        Person person2 = createPerson("Kenneth", "Taylor");
        person1.addSportsClub(ajax);
        person2.addSportsClub(ajax);

        sportsClubRepository.addSportsClub(ajax);
        entityManager.flush();
        entityManager.clear();

        SportsClub result = entityManager.find(SportsClub.class, ajax.getId());
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Ajax");
        List<Person> members = result.getMembers();
        assertThat(members).hasSize(2);
        assertThat(members.get(0).getFirstName()).isEqualTo("Dusan");
        assertThat(members.get(1).getFirstName()).isEqualTo("Kenneth");
    }

    private Person createPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(LocalDate.parse("1980-01-01"));
        return person;
    }
}
