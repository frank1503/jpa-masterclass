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

    public void createPerson(Person person) throws SQLException {
        String sql = "insert into person values (?, ?, ?, ?, ?)";//, ?, ?, ?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setObject(4, person.getDateOfBirth());
            preparedStatement.setString(5, person.getGender().name());

            preparedStatement.executeUpdate();
        }
    }

    public void updateFirstName(String firstName, int id) throws SQLException {
        String sql = "update person set firstname = ? where id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
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