package org.example;

import org.example.dao.FlightDao;
import org.example.dao.TicketDao;

import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        TicketDao ticketDao = TicketDao.getInstance();
        FlightDao flightDao = FlightDao.getInstance();
        System.out.println(flightDao.findAll());
    }
}
