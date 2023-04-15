package domain;

import java.io.Serializable;
import java.util.Objects;

public class CarPK implements Serializable {
    private int sequenceNumber;
    private String registrationPlate;

    public CarPK() {
    }

    public CarPK(int sequenceNumber, String registrationPlate) {
        this.sequenceNumber = sequenceNumber;
        this.registrationPlate = registrationPlate;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPK carPK = (CarPK) o;
        return sequenceNumber == carPK.sequenceNumber && Objects.equals(registrationPlate, carPK.registrationPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequenceNumber, registrationPlate);
    }
}
