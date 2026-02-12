package org.example;

import org.example.dao.TicketDao;
import org.example.dto.TicketFilter;

import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        TicketDao ticketDao = TicketDao.getInstance();
        TicketFilter filter = new TicketFilter(null, 2, 5, 0);
        System.out.println(ticketDao.findAll(filter));
    }
}
