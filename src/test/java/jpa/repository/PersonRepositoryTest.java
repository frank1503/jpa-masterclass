package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.Car;
import jpa.domain.Person;
import jpa.domain.SportsClub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldReadPersons() {
        List<Person> result = personRepository.findAllPersons();
        assertThat(result).hasSize(2);

        Person frank = result.get(0);
        assertThat(frank.getFirstName()).isEqualTo("Frank");

        Person rick = result.get(1);
        assertThat(rick.getFirstName()).isEqualTo("Rick");
    }

    @Test
    void shouldFindPersonByFirstName() {
        Person frank = personRepository.findPersonByFirstName("Frank");
        assertThat(frank.getFirstName()).isEqualTo("Frank");
    }

    @Test
    void shouldFindPersonByCarBrand() {
        List<Person> result = personRepository.findPersonByCarBrand("Seat");
        assertThat(result).hasSize(1);

        Person frank = result.get(0);
        assertThat(frank.getFirstName()).isEqualTo("Frank");
        Car seat = frank.getCar();
        assertThat(seat.getBrand()).isEqualTo("Seat");
    }

    @Test
    void shouldFindPersonsBySportClub() {
        List<Person> result = personRepository.findPersonsWithSportClub();
        assertThat(result).hasSize(2);

        Person rick = result.get(0);
        assertThat(rick.getFirstName()).isEqualTo("Rick");
        List<SportsClub> clubsRick = rick.getSportsClubs();
        assertThat(clubsRick).hasSize(2);
        assertThat(clubsRick.get(0).getName()).isEqualTo("CobraKai");
        assertThat(clubsRick.get(1).getName()).isEqualTo("FC De Treffers");

        Person frank = result.get(1);
        assertThat(frank.getFirstName()).isEqualTo("Frank");
        List<SportsClub> clubsFrank = frank.getSportsClubs();
        assertThat(clubsFrank).hasSize(2);
        assertThat(clubsFrank.get(0).getName()).isEqualTo("CobraKai");
        assertThat(clubsFrank.get(1).getName()).isEqualTo("FC De Treffers");
    }
}