package repository;

import domain.Address;
import domain.Gender;
import domain.Person;

import java.sql.*;
import java.time.LocalDate;

//TODO 3 in deze opdracht gaan we een Address toevoegen aan de Person.
// Het Address is een apart object maar in de database zitten de address velden in de person tabel (data clump)

//TODO 3a breid eerst de person tabel uit met de volgende velden:
// - streetname
// - housenumber
// - zipcode
// - city
// - country voer daarna het person.sql script uit (test -> java -> resources)
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
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    LocalDate dateOfBirth = resultSet.getObject(4, LocalDate.class);
                    Gender gender = Gender.valueOf(resultSet.getString(5));

                    //TODO 3b haal uit de resultSet de velden voor Address en maak het Person object
                }
            }
            return person;
        }
    }

    //TODO 3d we gaan nu het maken van een persoon aanpassen dat ook het address wordt opgeslagen
    public void createPerson(Person person) throws SQLException {
        //TODO 3e pas de query aan zodat ook de address velden opgeslagen worden
        String sql = "insert into person values (?, ?, ?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setObject(4, person.getDateOfBirth());
            preparedStatement.setString(5, person.getGender().name());

            //TODO 3f zorg dat de adrress velden worden opgeslagen

            preparedStatement.executeUpdate();
        }
    }

    public void updateFirstName(String firstName, int id) throws SQLException {
        String sql = "update person set first_name = ? where id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        }
    }

    //TODO 3h we gaan een methode maken die een address kan updaten
    public void updateAddress(Address updateAddress, int id) throws SQLException {
        //TODO 3i maak de query die het address kan updaten
        String sql = "";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            // TODO 3j zorg dat het address wordt aangepast
        }
    }

    public void deletePerson(int primaryKey) throws SQLException {
        String sql = "delete from person where id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, primaryKey);

            preparedStatement.executeUpdate();
        }
    }
}