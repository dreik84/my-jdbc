package org.example;

import org.example.dao.TicketDao;
import org.example.entity.Ticket;

import java.math.BigDecimal;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        TicketDao ticketDao = TicketDao.getInstance();
        Ticket ticket = new Ticket();
        ticket.setPassportNo("AR3434");
        ticket.setPassengerName("John");
        ticket.setFlightId(12L);
        ticket.setSeatNo(45);
        ticket.setCost(BigDecimal.TEN);

//        System.out.println(ticketDao.save(ticket));
        System.out.println(ticketDao.delete(11L));
    }
}
