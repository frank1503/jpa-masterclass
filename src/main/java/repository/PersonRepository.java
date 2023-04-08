package repository;

import domain.Person;
import jakarta.persistence.*;

public class PersonRepository {

    public Person readPerson(int primaryKey) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //TODO 5e haal de code uit commentaar en return de person ipv null.
        // De find methode haalt de Person voor je op.
        //Person person = em.find(Person.class, primaryKey);
        tx.commit();

        em.close();
        emf.close();

        return null;
    }

    public void createPerson(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-create");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //TODO 5f haal de code uit commentaar
        // De persist methode slaat de Person
        //em.persist(person);
        tx.commit();

        em.close();
        emf.close();
    }

    public void updatePerson(Person updatedPerson) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //TODO 5h haal onderstaande regel uit commentaar
        // De merge en persis methodes samen zorgen dat de Person wordt geupdate
        //Person person = em.merge(updatedPerson);
        //em.persist(person);
        tx.commit();

        em.close();
        emf.close();
    }

    public void deletePerson(int primaryKey) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //TODO 5j haal onderstaande regel uit commentaar
        // De remove methode verwijdert de Person
        tx.begin();
        //Person person = em.find(Person.class, primaryKey);
        //em.remove(person);
        tx.commit();

        em.close();
        emf.close();
    }
}
