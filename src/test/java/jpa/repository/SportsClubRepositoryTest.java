package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.Gender;
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
public class SportsClubRepositoryTest {

    @Autowired
    private SportsClubRepository sportsClubRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Sql("/add-person.sql")
    void shouldAddSportsClub() {
        SportsClub sportsClub = new SportsClub("FC De Treffers");

        Person person = entityManager.find(Person.class, 1);
        person.addSportsClub(sportsClub);

        int sportsClubId = sportsClubRepository.addSportsClub(sportsClub);
        entityManager.flush();
        entityManager.clear();

        SportsClub createdSportsClub = entityManager.find(SportsClub.class, sportsClubId);
        assertThat(createdSportsClub).isNotNull();
        assertThat(createdSportsClub.getName()).isEqualTo("FC De Treffers");

        List<Person> members = createdSportsClub.getMembers();
        assertThat(members).hasSize(1);
        assertThat(members.get(0).getFirstName()).isEqualTo("Rick");
    }
}
