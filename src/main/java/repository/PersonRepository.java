package repository;

import domain.Address;
import domain.Car;
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
        String sql = "select * from person p " +
                "left join car c on p.car_id = c.id " +
                "where p.id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, primaryKey);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int personId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    LocalDate dateOfBirth = resultSet.getObject(4, LocalDate.class);
                    Gender gender = Gender.valueOf(resultSet.getString(5));

                    String streetName = resultSet.getString(6);
                    String houseNumber = resultSet.getString(7);
                    String zipCode = resultSet.getString(8);
                    String city = resultSet.getString(9);
                    String country = resultSet.getString(10);

                    int carId = resultSet.getInt(12);
                    String type = resultSet.getString(13);
                    String colors = resultSet.getString(14);
                    String registrationPlate = resultSet.getString(15);

                    Car car = new Car(carId, type, colors, registrationPlate);
                    Address address = new Address(streetName, houseNumber, zipCode, city, country);
                    person = new Person(personId, firstName, lastName, dateOfBirth, gender, address);
                    person.setCar(car);
                }
            }
        }

        return person;
    }

    public void createPerson(Person person) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
            String personSql = "insert into person values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(personSql)) {
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
                preparedStatement.setInt(11, person.getCar().getId());

                preparedStatement.executeUpdate();
            }

            if (person.getCar() != null) {
                String carSql = "insert into car values (?, ?, ? , ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(carSql)) {
                    Car car = person.getCar();
                    preparedStatement.setInt(1, car.getId());
                    preparedStatement.setString(2, car.getType());
                    preparedStatement.setString(3, car.getColor());
                    preparedStatement.setString(4, car.getRegistrationPlate());

                    preparedStatement.executeUpdate();
                }
            }
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

    public void deletePerson(Person person) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
            String personSql = "delete from person where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(personSql)) {
                preparedStatement.setInt(1, person.getId());

                preparedStatement.executeUpdate();
            }
            if (person.getCar() != null) {
                String carSql = "delete from car where id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(carSql)) {
                    preparedStatement.setInt(1, person.getCar().getId());

                    preparedStatement.executeUpdate();
                }
            }
        }
    }
}