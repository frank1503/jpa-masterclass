package repository;

import domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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

    public int createPerson(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-create");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(person);
        tx.commit();

        em.close();
        emf.close();

        return person.getId();
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
