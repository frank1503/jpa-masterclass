package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(CarPK.class)
public class Car {
    //TODO 7b zorg dat serialNumber en type de Id vormen voor Car. Maak hiervoor een aparte primary key class
    @Id
    private int serialNumber;
    @Id
    private String type;
    private String color;
    private String registrationPlate;

    public Car() {
    }

    public Car(int serialNumber, String type, String color, String registrationPlate) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.color = color;
        this.registrationPlate = registrationPlate;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }
}
