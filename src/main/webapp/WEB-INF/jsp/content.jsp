<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.02.2026
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <span>CONTENT РУССКИЙ</span>
    <p>Size: ${requestScope.flights.size()}</p>
    <p>Description: ${requestScope.flights.get(0).description()}</p>
    <p>Id: ${requestScope.flights[0].id()}</p>
    <p>JSESSIONID: ${cookie.get("JSESSIONID")}</p>
    <p>Param id: ${param.id}</p>
    <p>Header cookie: ${header["cookie"]}</p>
    <p>Not empty: ${not empty flights}</p>
</div>
</body>
</html>
