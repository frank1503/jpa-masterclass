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
        Person person = em.merge(updatedPerson);
        em.persist(person);
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
