package domain;

//TODO 6b zorg dat Address als ingesloten object in de entity kan worden gebruikt
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
