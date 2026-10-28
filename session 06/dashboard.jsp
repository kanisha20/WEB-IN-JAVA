
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
    <h1>Welcome, <%= username %>!</h1>
    <p>You have successfully logged in.</p>

    <h3>Your Profile</h3>
    <a href="<%= request.getContextPath() %>/ProfileServlet?username=<%= java.net.URLEncoder.encode(username, "UTF-8") %>">
        View Profile
    </a>

    <br><br>

    <form action="LogoutServlet" method="POST">
        <button type="submit">Logout</button>
    </form>
</body>
</html>
