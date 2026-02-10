package org.example;

import org.example.dao.TicketDao;

import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        TicketDao ticketDao = TicketDao.getInstance();
        System.out.println(ticketDao.findById(10L));
        System.out.println(ticketDao.findAll());
    }
}
