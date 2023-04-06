package application;

import domain.Person;
import repository.PersonRepository;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        PersonRepository repository = new PersonRepository();

        Person person = repository.readPerson(1);
        System.out.println(person);

    }
}
