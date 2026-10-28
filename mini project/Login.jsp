
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
</head>
<body>
    <h2>Login</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;font-weight:bold">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <form action="LoginServlet" method="post">
        Username:
        <input type="text" name="username" required>
        <br><br>

        Password:
        <input type="password" name="password" required>
        <br><br>

        <button type="submit">Login</button>
    </form>

    <p>New user? <a href="RegisterUser.jsp">Register here</a></p>
</body>
</html>
