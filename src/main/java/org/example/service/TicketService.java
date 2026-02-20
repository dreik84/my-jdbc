package org.example.service;

import org.example.dao.TicketDao;
import org.example.dto.TicketDto;

import java.util.List;

public class TicketService {
    private final static TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream().map(
                ticket -> new TicketDto(ticket.getId(), ticket.getFlight().getId(), ticket.getSeatNo())
        ).toList();
    }


    private TicketService() {
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
