package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

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

            var dao = new UserDao(connection);
            var user = new User("Maria", "8888");
            System.out.println(user.getId()); // null

            dao.save(user);
            System.out.println(user.getId());

            var user2 = dao.find(user.getId()).get();
            System.out.println(Objects.equals(user2.getId(), user.getId()));

            sql = """
                    INSERT INTO users (username, phone) VALUES (?, ?);
                    """;

            try (var prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setString(1, "tomy");
                prepareStatement.setString(2, "1234");
                prepareStatement.executeUpdate();

                prepareStatement.setString(1, "jimy");
                prepareStatement.setString(2, "5678");
                prepareStatement.executeUpdate();
            }

            sql = "DELETE FROM users WHERE phone = ?";

            try (var prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setString(1, "5678");
                prepareStatement.executeUpdate();
            }

            sql = "SELECT * FROM users";

            try (var statement3 = connection.createStatement()) {
                var resultSet = statement3.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                    System.out.println(resultSet.getString("phone"));
                }
            }

            System.err.println(connection.getMetaData());
        }
    }
}
