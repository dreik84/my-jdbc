package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {

//        Class.forName("org.h2.Driver");

        var connection = DriverManager.getConnection("jdbc:h2:mem:testDB");

        var sql = """
                CREATE TABLE users (
                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    username VARCHAR(255),
                    phone VARCHAR(255)
                );
                """;

        var statement = connection.createStatement();
        statement.execute(sql);
        statement.close();

        sql = """
                INSERT INTO users (username, phone) VALUES ('tommy', '1234');
                """;

        var statement2 = connection.createStatement();
        statement2.executeUpdate(sql);
        statement2.closeOnCompletion();

        sql = "SELECT * FROM users";

        var statement3 = connection.createStatement();
        var resultSet = statement3.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
            System.err.println(resultSet.getString("phone"));
        }

        statement3.close();
        connection.close();
    }
}
