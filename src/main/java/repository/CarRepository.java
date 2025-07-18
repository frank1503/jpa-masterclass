package repository;

import domain.Car;
import domain.CarPK;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CarRepository {

    public Car readCar(CarPK carPK) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Car car = em.find(Car.class, carPK);
        tx.commit();

        em.close();
        emf.close();

        return car;
    }

    public CarPK createCar(Car car) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(car);
        tx.commit();

        em.close();
        emf.close();

        CarPK carPK = new CarPK();
        carPK.setSequenceNumber(car.getSequenceNumber());
        carPK.setRegistrationPlate(car.getRegistrationPlate());

        return carPK;
    }

    public void deleteCar(CarPK carPK) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-masterclass-none");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Car car = em.find(Car.class, carPK);
        em.remove(car);
        tx.commit();

        em.close();
        emf.close();
    }
}
