package repository;

import domain.Car;
import domain.CarPK;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRepositoryTest {
    private final CarRepository carRepository = new CarRepository();

    //TODO 7g draai de test, deze moet slagen. Controleer in de log dat de AUDIT logging voorbij is gekomen
    @Test
    void shouldCreateAndReadCar() {
        Car car = new Car(123, "Seat", "Blue", "P-468-LJ");
        CarPK carPK = carRepository.createCar(car);

        Car createdCar = carRepository.readCar(carPK);
        assertThat(createdCar.getSequenceNumber()).isEqualTo(123);
        assertThat(createdCar.getBrand()).isEqualTo("Seat");
        assertThat(createdCar.getColor()).isEqualTo("Blue");
        assertThat(createdCar.getRegistrationPlate()).isEqualTo("P-468-LJ");

        carRepository.deleteCar(carPK);

        Car deletedCar = carRepository.readCar(carPK);
        assertThat(deletedCar).isNull();
    }
}
