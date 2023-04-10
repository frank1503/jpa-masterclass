package domain;

public class Car {
    private int id;
    private String type;
    private String color;
    private String registrationPlate;

    public Car(int id, String type, String color, String registrationPlate) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.registrationPlate = registrationPlate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
