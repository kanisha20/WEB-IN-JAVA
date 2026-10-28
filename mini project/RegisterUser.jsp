
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h2>Register User</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <% if (request.getAttribute("message") != null) { %>
        <p style="color:green">
            <%= request.getAttribute("message") %>
        </p>
    <% } %>

    <form action="RegisterUserServlet" method="post">
        Username:
        <input type="text" name="username" required>
        <br><br>

        Email:
        <input type="email" name="email" required>
        <br><br>

        Password:
        <input type="password" name="password"
               minlength="6" required>
        <br><br>

        <button type="submit">Register</button>
    </form>

    <p>Already registered? <a href="Login.jsp">Login</a></p>
</body>
</html>
