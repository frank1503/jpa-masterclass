package domain;

//TODO 6b voeg de juiste annotatie toe de non-args constructor en getters en setters
public class Address {
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;

    public Address(String streetName, String houseNumber, String zipCode, String city, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
}
