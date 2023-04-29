package jpa.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverride(name = "streetName", column = @Column(name = "A_STREET_NAME"))
@AttributeOverride(name = "houseNumber", column = @Column(name = "A_HOUSE_NUMBER"))
@AttributeOverride(name = "zipCode", column = @Column(name = "A_ZIP_CODE"))
@AttributeOverride(name = "city", column = @Column(name = "A_CITY"))
@AttributeOverride(name = "country", column = @Column(name = "A_COUNTRY"))
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

    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
