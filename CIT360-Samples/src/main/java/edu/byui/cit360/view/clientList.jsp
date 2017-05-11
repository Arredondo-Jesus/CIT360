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
        <c:forEach items="${clients}" var="comment">
            <p>
                <strong><c:out value="${client.name}" /></strong><br>
                <strong><c:out value="${client.lastName}" /></strong><br>
                <strong><c:out value="${client.phoneNumber}" /></strong><br>
                <strong><c:out value="${client.email}" /></strong><br>
            </p>
        </c:forEach>
    </body>
</html>
