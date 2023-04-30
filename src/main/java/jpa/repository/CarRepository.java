package jpa.repository;

import jpa.domain.Car;
import jpa.domain.CarPK;

public interface CarRepository {

    Car findCarByBrandAndColor(String brand, String color);
}
