package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jpa.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    //TODO 13a draai eerst db_setup.sql
    // Maak een TypedQuery die alle personen ophaalt. Gebruik JPQL
    @Override
    public List<Person> findAllPersons() {
        return Collections.emptyList();
    }

    //TODO 13c maak een named query die een Person ophaalt op basis van de voornaam. Gebruik JPQL
    @Override
    public Person findPersonByFirstName(String firstName) {

        return null;
    }

    //TODO 13e maak een TypedQuery die personen ophaalt op basis van de brand van de Car Gebruik JPQL
    @Override
    public List<Person> findPersonByCarBrand(String brand) {

        return Collections.emptyList();
    }

    //TODO 13g Maak een TypedQuery die personen en bijbehorende sportsclubs ophaalt
    // De relatie SportsClubs worden lazy geladen maar zorg ervoor deze toch direct geladen worden bij het ophalen van Person.
    // sorteer het resultaat op voornaam aflopend
    // Gebruik JPQL
    @Override
    public List<Person> findPersonsWithSportClub() {

        return Collections.emptyList();
    }
}
