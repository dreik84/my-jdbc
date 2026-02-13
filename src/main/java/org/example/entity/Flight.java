package org.example.entity;

import java.time.LocalDate;

public class Flight {
    private Long id;
    private String flightNo;
    private LocalDate departureDate;
    private Long departureAirportCode;
    private LocalDate arrivalDate;
    private Long arrivalAirportCode;
    private Long aircraftId;
    private String status;
}
