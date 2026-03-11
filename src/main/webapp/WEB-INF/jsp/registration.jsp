<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="name">Name:
        <input type="text" name="name">
    </label><br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday">
    </label><br>
    <label for="email">Email:
        <input type="email" name="email">
    </label><br>
    <label for="pwd">Password:
        <input type="password" name="pwd">
    </label><br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option label="${role}">${role}</option>
            <br>
        </c:forEach>
    </select>
    <br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}"> ${gender}
        <br>
    </c:forEach>
    <br>
    <input type="submit" value="Send">
</form

<c:if test="${not empty requestScope.errors}">
    <div>
        <c:forEach var="error" items="${requestScope.errors}">
            <span style="color: red">${error.message}</span>
            <br>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
