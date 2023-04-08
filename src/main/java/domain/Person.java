package domain;

import java.time.LocalDate;

//TODO 5 Nu gaan we gebruik maken van JPA om de data uit de tabel te lezen. Voer eerst drop.sql script uit
// TODO 5a zorg dat de juiste annotatie op de Person class komt te staan
public class Person {
    //TODO 5b zorg dat de juiste annotatie op de id property komt te staan
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    //TODO 5c zorg dat de juiste annotatie op de gender property komt zodat de string-representatie in de database komt
    private Gender gender;

    public Person(int id, String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    //TODO 5d maak de benodigde constructor, getters en setters
}
