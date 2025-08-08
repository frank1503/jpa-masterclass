package message;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//TODO 8a voer eerst de message.sql (zie resources) uit
// In de lof4j2.xml (zie resources) staat nu de hibernate logging aan
// Deze kun je uitzetten als je wil
//
public class Opdracht8 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");

    public static void main(String... args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //eventueel bestaand record verwijderen
        tx.begin();
        Message message = em.find(Message.class, 1);
        if (message != null) {
            em.remove(message);
        }
        tx.commit();

        //TODO 8b start opdracht-8
        tx.begin();
        message = new Message(1, "AAA");
        print(1, message);

        em.persist(message);
        tx.commit();
        print(2, message);

        message.setText("BBB");
        tx.begin();
        em.refresh(message);
        print(3, message);

        em.detach(message);
        message.setText("CCC");
        print(4, message);

        tx.commit();
        print(5, message);

        tx.begin();
        message = em.merge(message);
        print(6, message);

        tx.commit();
        print(7, message);

        em.clear();
        message.setText("DDD");
        print(8, message);

        tx.begin();
        tx.commit();
        print(9, message);

        message = em.find(Message.class, 1);
        print(10, message);

        message.setText("EEE");
        print(11, message);

        tx.begin();
        tx.commit();
        message.setText("FFF");
        tx.begin();
        em.flush();
        message.setText("GGG");
        print(12, message);

        em.refresh(message);
        print(13, message);

        tx.rollback();
        print(14, message);

        tx.begin();
        message.setText("HHH");
        print(15, message);

        tx.commit();
        print(16, message);

        tx.begin();
        message = em.merge(message);
        print(17, message);

        tx.commit();
        print(18, message);

        em.clear();
        emf.close();
    }

    private static void print(int pos, Message memoryMessage) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Message messageFromDataBase = em.find(Message.class, memoryMessage.getId());
        tx.commit();
        em.close();

        System.out.println(pos + ": " + memoryMessage.getText() + "\t" +
                ((messageFromDataBase != null) ? messageFromDataBase.getText() : null));
    }
}
