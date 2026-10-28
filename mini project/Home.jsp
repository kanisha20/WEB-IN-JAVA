
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect(
            request.getContextPath() + "/Login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h2>Welcome, <%= username %>!</h2>

    <p>You are logged in successfully.</p>

    <a href="EventPost.jsp">Post a New Event</a>
    <br><br>
    <a href="EventListServlet">View All Events</a>
    <br><br>
    <a href="LogoutServlet">Logout</a>
</body>
</html>
