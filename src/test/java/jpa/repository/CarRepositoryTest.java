package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaApplication;
import jpa.domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EntityManager entityManager;

    //TODO 13j draai de test
    @Test
    void shouldFindCarByBrandAndColor() {
        Car car = carRepository.findCarByBrandAndColor("Ford", "Green");
        assertThat(car.getBrand()).isEqualTo("Ford");
        assertThat(car.getColor()).isEqualTo("Green");
    }

}
