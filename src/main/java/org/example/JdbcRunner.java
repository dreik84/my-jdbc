package org.example;

import org.example.dao.TicketDao;
import org.example.entity.Ticket;

import java.math.BigDecimal;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        TicketDao ticketDao = TicketDao.getInstance();
        Ticket ticket = ticketDao.findById(5L).get();
        System.out.println(ticket);
        ticket.setCost(new BigDecimal("200"));
        System.out.println(ticketDao.update(ticket));
        System.out.println(ticket);
    }
}
