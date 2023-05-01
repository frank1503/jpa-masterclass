package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpa.domain.Car;
import jpa.domain.CarPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Car readCar(CarPK carPK) {
        return entityManager.find(Car.class, carPK);
    }

    @Override
    public CarPK createCar(Car car) {
        entityManager.persist(car);

        return new CarPK(car.getSequenceNumber(), car.getRegistrationPlate());
    }

    @Override
    public void deleteCar(CarPK carPK) {
        //TODO 10e zorg dat Car verwijderd kan worden
        // de Person moet blijven bestaan in de database
    }
}
