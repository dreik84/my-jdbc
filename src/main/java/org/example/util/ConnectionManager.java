package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final static String URL = "jdbc:postgresql://localhost:5432/flight_repo";
    private final static String USER = "flight";
    private final static String PASSWORD = "root";

    public static Connection open() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionManager() {
    }
}