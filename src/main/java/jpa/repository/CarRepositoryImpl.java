package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jpa.domain.Car;
import jpa.domain.CarPK;
import org.springframework.stereotype.Repository;

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
        Car car = entityManager.find(Car.class, carPK);
        car.getPerson().setCar(null);
        entityManager.remove(car);
    }
}
