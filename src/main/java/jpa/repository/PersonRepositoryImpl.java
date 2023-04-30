package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jpa.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Person> findAllPersons() {
        TypedQuery<Person> typedQuery = entityManager.createQuery("select p from Person p", Person.class);
        return typedQuery.getResultList();
    }

    @Override
    public Person findPersonByFirstName(String firstName) {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery(Person.FIND_BY_FIRST_NAME, Person.class);
        namedQuery.setParameter("firstName", firstName);
        return namedQuery.getSingleResult();
    }

    @Override
    public List<Person> findPersonByCarBrand(String brand) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("select p from Person p where p.car.brand = :brand", Person.class);
        typedQuery.setParameter("brand", brand);
        return typedQuery.getResultList();
    }

    @Override
    public List<Person> findPersonsWithSportClub() {
        TypedQuery<Person> typedQuery = entityManager.createQuery("select p from Person p join fetch p.sportsClubs s óóorder by p.firstName desc", Person.class);
        return typedQuery.getResultList();
    }
}
