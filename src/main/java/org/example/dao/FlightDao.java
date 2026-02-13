package org.example.dao;

import org.example.entity.Flight;

import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    @Override
    public boolean update(Flight flight) {
        return false;
    }

    @Override
    public List<Flight> findAll() {
        return List.of();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Flight save(Flight flight) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
