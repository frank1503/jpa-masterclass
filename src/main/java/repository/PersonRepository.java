package repository;

import domain.Address;
import domain.Gender;
import domain.Person;

import java.sql.*;
import java.time.LocalDate;

//TODO 4 In deze opdracht gaan we een Car object toevoegen en een aparte tabel maken voor dit object.
// Op het person object voegen we een Car toe en in de database krijgt de person tabel een verwijzing naar car (car_id)

//TODO 4a maak de nieuwe car tabel:
// - id
// - type
// - color
// - registrationplate
// voeg kolom car_id toe aan de person tabel
// tot slot, voer car.sql script uit
public class PersonRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/jpa";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    public Person readPerson(int primaryKey) throws SQLException {
        Person person = null;

        //TODO 4b pas de query aan zodat ook de Car wordt opgehaald als deze er is
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

                    String streetName = resultSet.getString(6);
                    String houseNumber = resultSet.getString(7);
                    String zipCode = resultSet.getString(8);
                    String city = resultSet.getString(9);
                    String country = resultSet.getString(10);

                    //TODO 4c haal uit de resultSet de velden voor Car en zorg ervoor dat Car wordt geset op Person

                    Address address = new Address(streetName, houseNumber, zipCode, city, country);
                    person = new Person(id, firstName, lastName, dateOfBirth, gender, address);
                }
            }
            return person;
        }
    }

    //TODO 4e zorg ervoor dat als een Person wordt opgeslagen ook de bijbehorende Car wordt opgeslagen
    public void createPerson(Person person) throws SQLException {
        String sql = "insert into person values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setObject(4, person.getDateOfBirth());
            preparedStatement.setString(5, person.getGender().name());

            preparedStatement.setString(6, person.getAddress().getStreetName());
            preparedStatement.setString(7, person.getAddress().getHouseNumber());
            preparedStatement.setString(8, person.getAddress().getZipCode());
            preparedStatement.setString(9, person.getAddress().getCity());
            preparedStatement.setString(10, person.getAddress().getCountry());

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

    public void updateAddress(Address updateAddress, int id) throws SQLException {
        String sql = "update person " +
                "set street_name = ? " +
                ", house_number = ? " +
                ", zip_code = ? " +
                ", city = ? " +
                ", country = ? " +
                "where id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            {
                preparedStatement.setString(1, updateAddress.getStreetName());
                preparedStatement.setString(2, updateAddress.getHouseNumber());
                preparedStatement.setString(3, updateAddress.getZipCode());
                preparedStatement.setString(4, updateAddress.getCity());
                preparedStatement.setString(5, updateAddress.getCountry());
                preparedStatement.setInt(6, id);

                preparedStatement.executeUpdate();
            }
        }
    }

    //TODO 4g zorg ervoor dat als een Person een Car heeft, deze ook wordt verwijderd
    public void deletePerson(Person person) throws SQLException {
        String sql = "delete from person where id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, person.getId());

            preparedStatement.executeUpdate();
        }
    }
}