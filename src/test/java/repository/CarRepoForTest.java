package repository;

import domain.Car;

import java.sql.*;

public class CarRepoForTest {
    private static final String URL = "jdbc:postgresql://localhost:5432/jpa";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    public Car getCar(int primaryKey) throws SQLException {
        Car car = null;
        String sql = "select * from car c where c.id = ?";

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, primaryKey);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("type");
                    String color = resultSet.getString("color");
                    String registrationPlate = resultSet.getString("registrationplate");

                    car = new Car(id, type, color, registrationPlate);
                }
            }
            return car;
        }
    }
}
