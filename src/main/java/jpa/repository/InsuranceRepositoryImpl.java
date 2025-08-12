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

    // TODO 11c implementeer de methode zodat een insurance kan worden toegevoegd aan de Person
    @Override
    public int addInsurance(Insurance insurance) {
        //return id van insurance ipv 0
        return 0;
    }

    // TODO 11d implementeer de methode zodat je een insurance kan vinden op basis van zijn id
    @Override
    public Insurance readInsurance(int id) {
        return null;
    }
}
