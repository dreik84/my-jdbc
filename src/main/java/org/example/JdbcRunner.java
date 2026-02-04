package org.example;

import com.github.javafaker.Faker;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Faker faker = Faker.instance();

        String sql = """
                INSERT INTO flight (aircraft_id, seat_no) VALUES (?, ?);
                """;

        try (Connection connection = ConnectionManager.open();
             var statement = connection.prepareStatement(sql)) {

            for (int i = 1; i < 4; i++) {
                statement.setLong(1, i);
                for (int j = 1; j < 4; j++) {
                    statement.setString(2, "C" + j);
                    statement.executeUpdate();
                }
                ;
            }
        }
    }
}
