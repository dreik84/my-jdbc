package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        Class.forName("org.h2.Driver");

        var connection = DriverManager.getConnection("jdbc:h2:mem:testDB");

    }
}
