package domain;

import jakarta.persistence.*;

import java.time.LocalDate;

//TODO 7 draai eerst het drop-and-create script zodat je met een schone database kan beginnen
@Entity
public class Person {
    //TODO 7a zorg dat primary key automatisch gegenereerd wordt met de IDENTITY strategie
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Embedded
    private Address address;

    //TODO 7b voeg het veld age toe, maar zorg ervoor dat deze niet als kolom in de tabel terecht komt.
    // Maak daarna een methode die de age automatisch bepaalt als de entity wordt opgehaald uit de database

    public Person(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Person() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
