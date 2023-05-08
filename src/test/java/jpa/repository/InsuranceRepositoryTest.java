package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.Gender;
import jpa.domain.Insurance;
import jpa.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
public class InsuranceRepositoryTest {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private EntityManager entityManager;


    //TODO 11i haal de code uit commentaar en draai de test, deze moet slagen
    @Test
    @Sql("/add-person.sql")
    void shouldAddInsuranceToPerson() {
//        Insurance carInsurance = new Insurance("car", new BigDecimal("104.89"));
//
//        Person person = entityManager.find(Person.class, 1);
//        person.addInsurance(carInsurance);
//
//        int insuranceId = insuranceRepository.addInsurance(carInsurance);
//        entityManager.flush();
//        entityManager.clear();
//
//        Insurance createdInsurance = entityManager.find(Insurance.class, insuranceId);
//        assertThat(createdInsurance).isNotNull();
//        assertThat(createdInsurance.getType()).isEqualTo("car");
//        assertThat(carInsurance.getPerson()).isNotNull();
//        assertThat(carInsurance.getPerson().getFirstName()).isEqualTo("Rick");
    }


    //TODO 11j haal de code uit commentaar draai de test, deze moet slagen
    @Test
    @Sql("/add-person-with-insurance.sql")
    void shouldReadInsurance() {
//        Insurance createdInsurance = insuranceRepository.readInsurance(1);
//        assertThat(createdInsurance).isNotNull();
//        assertThat(createdInsurance.getPerson().getFirstName()).isEqualTo("Rick");
    }
}
