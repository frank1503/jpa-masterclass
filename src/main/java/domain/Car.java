package domain;

import jakarta.persistence.Entity;

//TODO 7b zorg dat registrationPlate en sequenceNumber de primary key vormen voor Car.
@Entity
public class Car {

    private String registrationPlate;
    private int sequenceNumber;
    private String brand;
    private String color;

    public Car() {
    }

    public Car(int sequenceNumber, String brand, String color, String registrationPlate) {
        this.sequenceNumber = sequenceNumber;
        this.brand = brand;
        this.color = color;
        this.registrationPlate = registrationPlate;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int serialNumber) {
        this.sequenceNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String type) {
        this.brand = type;
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
