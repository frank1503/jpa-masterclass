package jpa.repository;

import jpa.domain.Person;

public interface PersonRepository {
    Person readPerson(int primaryKey);

    int createPerson(Person person);

    void updatePerson(Person updatedPerson);

    void deletePerson(int primaryKey);
}
