package org.example.dao;

import org.example.entity.Ticket;
import org.example.exeption.DaoException;
import org.example.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    private final static TicketDao INSTANCE = new TicketDao();

    private final static String SAVE_SQL = """
            INSERT INTO ticket (passport_no, passenger_name, flight_id, seat_no, cost)
            VALUES (?, ?, ?, ?, ?)
            """;

    private final static String DELETE_SQL = """
            DELETE FROM ticket WHERE id = ?
            """;

    private final static String FIND_ALL_SQL = """
            SELECT id, passport_no, passenger_name, flight_id, seat_no, cost
            FROM ticket
            """;

    private final static String FIND_BY_ID = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    public Ticket save(Ticket ticket) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, ticket.getPassportNo());
            statement.setString(2, ticket.getPassengerName());
            statement.setLong(3, ticket.getFlightId());
            statement.setInt(4, ticket.getSeatNo());
            statement.setBigDecimal(5, ticket.getCost());

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();

            if (keys.next())
                ticket.setId(keys.getLong("id"));

            return ticket;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Ticket findById(Long id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID)) {

            statement.setLong(1, id);

            var result = statement.executeQuery();
            Ticket ticket = null;

            if (result.next()) {
                ticket = buildTicket(result);
            }

            return ticket;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<Ticket> findAll() {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_ALL_SQL)) {

            List<Ticket> tickets = new ArrayList<>();

            var result = statement.executeQuery();

            while (result.next()) {
                tickets.add(buildTicket(result));
            }

            return tickets;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private static Ticket buildTicket(ResultSet result) throws SQLException {
        return new Ticket(
                result.getLong("id"),
                result.getString("passport_no"),
                result.getString("passenger_name"),
                result.getLong("flight_id"),
                result.getInt("seat_no"),
                result.getBigDecimal("cost")
        );
    }

    public boolean delete(Long id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(DELETE_SQL)) {

            statement.setLong(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    private TicketDao() {
    }
}
