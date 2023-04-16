package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpa.domain.Car;
import jpa.domain.CarPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//TODO 9c implementeer de repository
@Repository
@Transactional
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Car readCar(CarPK carPK) {
        return null;
    }

    @Override
    public CarPK createCar(Car car) {

        return new CarPK(car.getSequenceNumber(), car.getRegistrationPlate());
    }

    @Override
    public void deleteCar(CarPK carPK) {

    }
}
