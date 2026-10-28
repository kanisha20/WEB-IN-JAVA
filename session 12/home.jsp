
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

    <h1>
        Welcome, <%= session.getAttribute("username") %>!
    </h1>

    <p>You have logged in successfully.</p>

    <a href="LogoutServlet">Logout</a>

</body>
</html>
