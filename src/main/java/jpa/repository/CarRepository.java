package jpa.repository;

import jpa.domain.Car;
import jpa.domain.CarPK;

public interface CarRepository {
    Car readCar(CarPK carPK);

    CarPK createCar(Car car);

    void deleteCar(CarPK carPK);
}
