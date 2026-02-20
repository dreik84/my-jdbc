package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.TicketService;

import java.io.IOException;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Long flightId = Long.valueOf(req.getParameter("flightId"));

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Купленные билеты</h1>");
            writer.write("<ul>");
            ticketService.findAllByFlightId(flightId).forEach(ticketDto -> {
                writer.write("<li>" + ticketDto.seatNo() + "</li>");
            });
            writer.write("</ul>");
        }

    }
}
