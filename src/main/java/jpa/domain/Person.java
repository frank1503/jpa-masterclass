package jpa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Embedded
    private Address address;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> telephoneNumbers = new ArrayList<>();
    @Transient
    private int age;
    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
            , orphanRemoval = true
    )
    private Car car;

    // TODO 11b voeg hier ook de bidirectionele relatie met Insurance toe
    // insurances: List<Insurance>


    // TODO 11f voeg hier ook de bidirectione relatie met SportsClub toe
    // sportsClubs: List<SportsClub>


    public Person(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @PostLoad
    public void determineAge() {
        this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public Person() {
    }

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

    public int getAge() {
        return age;
    }

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    //TODO 11g haal deze 2 methoden uit commentaar
//    public void addSportsClub(SportsClub sportsClub) {
//        sportsClub.getMembers().add(this);
//        this.sportsClubs.add(sportsClub);
//    }
//
//    public void addInsurance(Insurance insurance) {
//        this.insurances.add(insurance);
//        insurance.setPerson(this);
//    }
}
