package jpa.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InsuranceRepositoryImpl implements InsuranceRepository {

    @PersistenceContext
    EntityManager entityManager;



}
