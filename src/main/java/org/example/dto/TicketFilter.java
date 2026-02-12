package org.example.dto;

public record TicketFilter(String passengerName, int seatNo, int limit, int offset) {
}
