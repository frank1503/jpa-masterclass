package jpa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XAT403")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private int id;
    @Column(name = "P_FIRST_NAME")
    private String firstName;
    @Column(name = "P_LAST_NAME")
    private String lastName;
    @Column(name = "P_DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "P_GENDER")
    private Gender gender;
    @Embedded
    private Address address;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TELEFOONNUMMERS", joinColumns = @JoinColumn(name = "P_ID"))
    @Column(name = "TELEFOONNUMMER")
    private List<String> telephoneNumbers = new ArrayList<>();
    @Transient
    private int age;
    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
            , orphanRemoval = true

    )
    @JoinColumns({
            @JoinColumn(name = "X_NUMSCHILD", referencedColumnName = "X_NUMMERNSCHILD"),
            @JoinColumn(name = "X_SERIENNUM", referencedColumnName = "X_SERIENNUMMER")
    })
    private Car car;
    @OneToMany(
            mappedBy = "person"
            , cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
            , fetch = FetchType.EAGER
            , orphanRemoval = true
    )
    private List<Insurance> insurances = new ArrayList<>();
    @ManyToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "PERSON_TO_CLUB"
            , joinColumns = @JoinColumn(name = "P_ID")
            , inverseJoinColumns = @JoinColumn(name = "SC_ID"))
    private List<SportsClub> sportsClubs = new ArrayList<>();


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

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public List<SportsClub> getSportsClubs() {
        return sportsClubs;
    }

    public void setSportsClubs(List<SportsClub> sportsClubs) {
        this.sportsClubs = sportsClubs;
    }

    public void addSportsClub(SportsClub sportsClub) {
        sportsClub.getMembers().add(this);
        this.sportsClubs.add(sportsClub);
    }
}
