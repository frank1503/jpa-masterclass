package jpa.domain;

import domain.AuditTrailerListener;
import jakarta.persistence.*;

@EntityListeners(AuditTrailerListener.class)
@Entity
@IdClass(CarPK.class)
@Table(name = "X_PERSON_OBJEKT")
public class Car {
    @Id
    @Column(name = "X_NUMMERNSCHILD")
    private String registrationPlate;
    @Id
    @Column(name = "X_SERIENNUMMER")
    private int sequenceNumber;
    @Column(name = "X_MARKE")
    private String brand;
    @Column(name = "X_FARBE")
    private String color;
    @OneToOne(mappedBy = "car", cascade = CascadeType.PERSIST)
    private Person person;

    public Car() {
    }

    public Car(int sequenceNumber, String registrationPlate, String brand, String color) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
