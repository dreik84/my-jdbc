package org.example.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Flight {
    private Long id;
    private String flightNo;
    private LocalDate departureDate;
    private Long departureAirportCode;
    private LocalDate arrivalDate;
    private Long arrivalAirportCode;
    private Long aircraftId;
    private FlightStatus status;

    public Flight(Long id, String flightNo, LocalDate departureDate, Long departureAirportCode, LocalDate arrivalDate, Long arrivalAirportCode, Long aircraftId, FlightStatus status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.aircraftId = aircraftId;
        this.status = status;
    }

    public Flight() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureAirportCode(Long departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalAirportCode(Long arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public Long getDepartureAirportCode() {
        return departureAirportCode;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Long getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public FlightStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", departureDate=" + departureDate +
                ", departureAirportCode=" + departureAirportCode +
                ", arrivalDate=" + arrivalDate +
                ", arrivalAirportCode=" + arrivalAirportCode +
                ", aircraftId=" + aircraftId +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(flightNo, flight.flightNo) && Objects.equals(departureDate, flight.departureDate) && Objects.equals(departureAirportCode, flight.departureAirportCode) && Objects.equals(arrivalDate, flight.arrivalDate) && Objects.equals(arrivalAirportCode, flight.arrivalAirportCode) && Objects.equals(aircraftId, flight.aircraftId) && status == flight.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNo, departureDate, departureAirportCode, arrivalDate, arrivalAirportCode, aircraftId, status);
    }
}
