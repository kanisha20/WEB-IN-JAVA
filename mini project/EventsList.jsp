
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.model.Event" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Events</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background: #f5f7fb;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background: #2874f0;
            color: white;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>

<h2>All Events</h2>

<%
    String error = (String) request.getAttribute("error");
    List<Event> events =
        (List<Event>) request.getAttribute("events");
%>

<% if (error != null) { %>

    <p class="error"><%= error %></p>

<% } else if (events == null || events.isEmpty()) { %>

    <p>No events available.</p>

<% } else { %>

    <table>
        <tr>
            <th>ID</th>
            <th>Posted By</th>
            <th>Event Title</th>
            <th>Date</th>
            <th>Description</th>
        </tr>

        <% for (Event event : events) { %>
        <tr>
            <td><%= event.getId() %></td>
            <td><%= event.getUsername() %></td>
            <td><%= event.getTitle() %></td>
            <td><%= event.getEventDate() %></td>
            <td><%= event.getDescription() %></td>
        </tr>
        <% } %>
    </table>

<% } %>

<br>
<a href="Home.jsp">Back to Home</a>
<br><br>
<a href="EventPost.jsp">Post Another Event</a>

</body>
</html>
