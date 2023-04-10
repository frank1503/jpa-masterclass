package domain;

import java.io.Serializable;
import java.util.Objects;

public class CarPK implements Serializable {
    private int serialNumber;
    private String type;

    public CarPK() {
    }

    public CarPK(int serialNumber, String type) {
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPK carPK = (CarPK) o;
        return serialNumber == carPK.serialNumber && Objects.equals(type, carPK.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, type);
    }
}
