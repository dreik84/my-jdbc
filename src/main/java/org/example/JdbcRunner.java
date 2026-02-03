package org.example;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Faker faker = Faker.instance();

        String sql = """
                INSERT INTO airport (code, country, city) VALUES (?, ?, ?);
                """;

        try (Connection connection = ConnectionManager.open();
             var statement = connection.prepareStatement(sql)) {

            for (int i = 1; i < 5; i++) {
                Country country = faker.country();
                long nextLong = faker.random().nextLong(1000);

                statement.setLong(1, nextLong);
                statement.setString(2, country.name());
                statement.setString(3, country.capital());
                statement.executeUpdate();
            }
        }
    }
}
