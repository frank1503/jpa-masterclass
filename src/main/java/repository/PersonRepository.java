package repository;

import domain.Gender;
import domain.Person;

import java.sql.*;
import java.time.LocalDate;

public class PersonRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/jpa";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    public Person readPerson(int primaryKey) throws SQLException {
        Person person = null;

        String sql = "select * from person p where p.id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, primaryKey);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    LocalDate dateOfBirth = resultSet.getObject("dateofbirth", LocalDate.class);
                    Gender gender = Gender.valueOf(resultSet.getString("gender"));

                    person = new Person(id, firstName, lastName, dateOfBirth, gender);
                }
            }
            return person;
        }
    }

    //TODO opdracht 2 in deze opdracht gaan we de andere 3 operaties va de CRUD maken (create, update en delete).
    // Draai eerst de volgende testen: PersonRepositoryTest.shouldCreatePerson() / shouldUpdate() / shouldDelete. Deze falen
    // We beginnen met de create
    public void createPerson(Person person) throws SQLException {
        //TODO 2a maak de query die een persoon kan toevoegen
        String sql = "";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            //TODO 2b zorg ervoor dat de properties van het person object in de database terecht komen
        }
    }

    //TODO 2d we gaan een methode maken die de firstName van een bepaalde Person doet updaten
    public void updateFirstName(String firstName, int id) throws SQLException {
        //TODO 2e maak de query die de update doet
        String sql = "";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            //TODO 2f zorg dat de update van de firstName wordt uitgevoerd
        }
    }

    //TODO 2h tot slot gaan we een methode maken die een persoon verwijderd op basis van de primary key
    public void deletePerson(int primaryKey) throws SQLException {
        //TODO 2i maak de query die de delete doet
        String sql = "";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            //TODO 2j zorg dat de person wordt verwijderd
        }
    }
}