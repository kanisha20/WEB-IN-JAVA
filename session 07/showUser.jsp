
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
    <%
        String username = request.getParameter("username");

        if (username == null || username.trim().isEmpty()) {
            username = "Guest";
        }
    %>

    <h2>Welcome, <%= username %>!</h2>

    <p>Current Date: <%= LocalDate.now() %></p>
</body>
</html>
