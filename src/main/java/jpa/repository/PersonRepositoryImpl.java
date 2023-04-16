package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpa.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Person readPerson(int primaryKey) {
        return entityManager.find(Person.class, primaryKey);
    }

    @Override
    public int createPerson(Person person) {
        entityManager.persist(person);

        return person.getId();
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        Person person = entityManager.merge(updatedPerson);
        entityManager.persist(person);
    }

    @Override
    public void deletePerson(int primaryKey) {
        Person person = entityManager.find(Person.class, primaryKey);
        entityManager.remove(person);
    }
}
