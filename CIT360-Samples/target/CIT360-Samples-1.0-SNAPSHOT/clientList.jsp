<%--
    Document   : clientList
    Created on : May 6, 2017, 11:38:07 PM
    Author     : Jesus Arredondo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client List</title>
    </head>
    <body>
        <h1>Client List!</h1>
        <c:forEach items="${clients}" var="client">
            <p>
                <strong>Name: </strong><c:out value="${client.name}" /><br>
                <strong>Last Name: </strong><c:out value="${client.lastName}" /><br>
                <strong>Phone Number: </strong><c:out value="${client.phoneNumber}" /><br>
                <strong>Email: </strong><c:out value="${client.email}" /><br>
            </p>
        </c:forEach>
    </body>
</html>
