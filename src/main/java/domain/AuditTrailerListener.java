package domain;

import jakarta.persistence.*;
import jpa.domain.Car;

import java.util.logging.Logger;

public class AuditTrailerListener {
    private final static Logger LOGGER = Logger.getLogger(AuditTrailerListener.class.getName());

    @PrePersist
    private void beforeCreate(Car car) {
        LOGGER.info("**************[CAR AUDIT] About to add car: " + car.getRegistrationPlate() + "**************");
    }

    @PostPersist
    private void afterCreate(Car car) {
        LOGGER.info("**************[CAR AUDIT] Add complete for car: " + car.getRegistrationPlate() + "**************");
    }


    @PreRemove
    private void beforeDelete(Car car) {
        LOGGER.info("**************[CAR AUDIT] About to delete car: " + car.getRegistrationPlate() + "**************");
    }

    @PostRemove
    private void afterDelete(Car car) {
        LOGGER.info("**************[CAR AUDIT] Delete complete for car: " + car.getRegistrationPlate() + "**************");
    }
}
