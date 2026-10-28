
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect(
            request.getContextPath() + "/Login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Event</title>
</head>
<body>
    <h2>Create a New Event</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <form action="EventPostServlet" method="post">
        Event Title:
        <input type="text" name="title" required>
        <br><br>

        Event Date:
        <input type="date" name="eventDate" required>
        <br><br>

        Description:
        <textarea name="description" required></textarea>
        <br><br>

        <button type="submit">Post Event</button>
    </form>

    <p><a href="Home.jsp">Back to Home</a></p>
</body>
</html>
