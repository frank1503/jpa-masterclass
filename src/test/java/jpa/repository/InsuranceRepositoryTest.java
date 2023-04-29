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
@Sql("/db_setup.sql")
public class InsuranceRepositoryTest {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldAddInsuranceToPerson() {
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Insurance carInsurance = new Insurance("car", new BigDecimal("104.89"));
        carInsurance.setPerson(person);
        insuranceRepository.addInsurance(carInsurance);
        entityManager.flush();
        entityManager.clear();

        Person createdPerson = entityManager.find(Person.class, person.getId());
        assertThat(createdPerson.getInsurances()).hasSize(1);
    }

    @Test
    void shouldReadInsurance() {
        Person person = new Person("Rick", "Roelofsen", LocalDate.parse("1986-03-15"), Gender.MALE);
        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Insurance carInsurance = new Insurance("car", new BigDecimal("104.89"));
        carInsurance.setPerson(person);
        entityManager.persist(carInsurance);
        entityManager.flush();
        entityManager.clear();

        Insurance createdInsurance = insuranceRepository.readInsurance(carInsurance.getId());
        assertThat(createdInsurance).isNotNull();
        assertThat(createdInsurance.getPerson().getFirstName()).isEqualTo("Rick");
    }
}
