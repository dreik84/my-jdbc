package org.example;

import com.github.javafaker.Faker;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Faker faker = Faker.instance();

        String sql = """
                DROP TABLE IF EXISTS test;
                
                CREATE TABLE IF NOT EXISTS test (
                  id SERIAL PRIMARY KEY,
                  data VARCHAR(256)
                );
                
                INSERT INTO test (data)
                VALUES 
                    ('TEXT %s'),
                    ('TEXT %s'),
                    ('TEXT %s'),
                    ('TEXT %s')
                """.formatted(faker.animal().name(), faker.artist().name(), faker.book().title(), faker.color().name());

        try (Connection connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            System.out.println(statement.execute(sql));
        }
    }
}
