package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.SportsClub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    //TODO 13l draai de test
    @Test
    void shouldFindSportsClubByName() {
        SportsClub cobraKai = sportsClubRepository.findSportsClubByName("CobraKai");
        assertThat(cobraKai.getName()).isEqualTo("CobraKai");
    }
}
