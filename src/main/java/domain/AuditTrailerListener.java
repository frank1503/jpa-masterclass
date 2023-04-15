package domain;

import java.util.logging.Logger;

//TODO 7f geef de onderstaande gegevens de juiste levenscyclus annotatie
public class AuditTrailerListener {
    private final static Logger LOGGER = Logger.getLogger(AuditTrailerListener.class.getName());

    private void beforeCreate(Car car) {
        LOGGER.info("**************[CAR AUDIT] About to add car: " + car.getRegistrationPlate() + "**************");
    }

    private void afterCreate(Car car) {
        LOGGER.info("**************[CAR AUDIT] Add complete for car: " + car.getRegistrationPlate() + "**************");
    }


    private void beforeDelete(Car car) {
        LOGGER.info("**************[CAR AUDIT] About to delete car: " + car.getRegistrationPlate() + "**************");
    }

    private void afterDelete(Car car) {
        LOGGER.info("**************[CAR AUDIT] Delete complete for car: " + car.getRegistrationPlate() + "**************");
    }
}
