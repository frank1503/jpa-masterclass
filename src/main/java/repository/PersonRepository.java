package repository;

import domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/jpa";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    //TODO Opdracht 1: In deze opdracht gaan we een person uit de database lezen.
    // Draai eerst de test PersonRepositoryTest.shouldReadPerson(). Deze faalt nu omdat person null is
    // op basis van de primary key die we binnen krijgen
    public Person readPerson(int primaryKey) throws SQLException {
        Person person = null;

        //TODO 1a maak een query die persoon ophaalt.
        // Als het goed is, is dit de person die je in de voorbereiding zelf hebt toegevoegd
        String sql = "";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            //TODO 1b haal de data op en maak een Person object met plain java (denk aan het JDBC hoofdstuk van je OCP)
        }

        return person;
    }
}
