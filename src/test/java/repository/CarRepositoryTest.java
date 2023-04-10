package repository;

import domain.Car;
import domain.CarPK;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRepositoryTest {
    private final CarRepository carRepository = new CarRepository();

    //TODO 7c draai de test, deze moet slagen
    @Test
    void shouldCreateAndReadCar() {
        Car car = new Car(123, "Seat", "Blue", "P-468-LJ");
        CarPK carPK = carRepository.createCar(car);

        Car createdCar = carRepository.readCar(carPK);
        assertThat(createdCar.getSerialNumber()).isEqualTo(123);
        assertThat(createdCar.getType()).isEqualTo("Seat");
        assertThat(createdCar.getColor()).isEqualTo("Blue");
        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");
    }
}
