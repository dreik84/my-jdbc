<%@ page import="org.example.service.TicketService" %>
<%@ page import="org.example.dto.TicketDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.02.2026
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты</h1>
<ul>
    <%
        TicketService ticketService = TicketService.getInstance();
        Long flightId = Long.valueOf(request.getParameter("flightId"));

        for (TicketDto ticketDto : ticketService.findAllByFlightId(flightId)) {
            out.write(String.format("<li>%s</li>", ticketDto.seatNo()));
        }
    %>
</ul>
</body>
</html>
