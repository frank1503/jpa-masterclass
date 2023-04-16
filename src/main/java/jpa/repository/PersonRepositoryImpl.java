package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpa.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
//TODO 9a implementeer de reporistory
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Person readPerson(int primaryKey) {

        return null;
    }

    @Override
    public int createPerson(Person person) {

        return person.getId();
    }

    @Override
    public void updatePerson(Person updatedPerson) {

    }

    @Override
    public void deletePerson(int primaryKey) {

    }
}
