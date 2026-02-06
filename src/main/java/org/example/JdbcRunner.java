package org.example;

import com.github.javafaker.Faker;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Faker faker = Faker.instance();

        String sql = """
                SELECT flight.flight_no
                FROM flight 
                WHERE arrival_date 
                BETWEEN ? AND ?
                """;

        try (Connection connection = ConnectionManager.open();
             var statement = connection.prepareStatement(sql)) {

            statement.setFetchSize(2);
            statement.setMaxRows(2);
            statement.setQueryTimeout(1);

            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData);


            statement.setDate(1, Date.valueOf(LocalDate.now().minusDays(2)));
            statement.setDate(2, Date.valueOf(LocalDate.now().plusDays(2)));
            var resultSet = statement.executeQuery();

            while (resultSet.next())
                System.out.println(resultSet.getString("flight_no"));
        }
    }
}
