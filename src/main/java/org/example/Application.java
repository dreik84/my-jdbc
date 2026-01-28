package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {

//        Class.forName("org.h2.Driver");

        try (var connection = DriverManager.getConnection("jdbc:h2:mem:testDB")) {
            var sql = """
                    CREATE TABLE users (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(255),
                        phone VARCHAR(255)
                    );
                    """;

            try (var statement = connection.createStatement()) {
                statement.execute(sql);
            }

            sql = """
                    INSERT INTO users (username, phone) VALUES ('tommy', '1234');
                    """;

            try (var statement2 = connection.createStatement()) {
                statement2.executeUpdate(sql);
            }

            sql = "SELECT * FROM users";

            try (var statement3 = connection.createStatement()) {
                var resultSet = statement3.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                    System.err.println(resultSet.getString("phone"));
                }
            }
        }
    }
}
