package jpa.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpa.domain.Insurance;
import jpa.domain.Person;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InsuranceRepositoryImpl implements InsuranceRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addInsurance(Insurance insurance) {
        Person person = entityManager.find(Person.class, insurance.getPerson().getId());
        person.getInsurances().add(insurance);
    }

    @Override
    public Insurance readInsurance(int id) {
        return entityManager.find(Insurance.class, id);
    }
}
