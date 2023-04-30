package jpa.repository;

import jpa.domain.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findAllPersons();

    Person findPersonByFirstName(String firstName);

    List<Person> findPersonByCarBrand(String brand);

    List<Person> findPersonsWithSportClub();
}
