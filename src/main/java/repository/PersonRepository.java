package repository;

import domain.Address;
import domain.Person;
import jakarta.persistence.*;

public class PersonRepository {

    public Person readPerson(int primaryKey) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Person person = em.find(Person.class, primaryKey);
        tx.commit();

        em.close();
        emf.close();

        return person;
    }

    public void createPerson(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-create");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(person);
        tx.commit();

        em.close();
        emf.close();
    }

    public void updatePerson(Person updatedPerson) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Person person = em.find(Person.class, updatedPerson.getId());
        person.setFirstName(updatedPerson.getFirstName());
        person.setLastName(updatedPerson.getLastName());
        person.setDateOfBirth(updatedPerson.getDateOfBirth());
        person.setGender(updatedPerson.getGender());

        //TODO 6d zorg ervoor dat de address properties uit updatedPerson geset worden op de hierboven opgehaald person

        tx.commit();

        em.close();
        emf.close();
    }

    public void deletePerson(int primaryKey) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Person person = em.find(Person.class, primaryKey);
        em.remove(person);
        tx.commit();

        em.close();
        emf.close();
    }
}
