
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup Successful</title>
</head>
<body>
    <h2 style="color:green">
        <%= request.getAttribute("success") %>
    </h2>
    <a href="login.jsp">Go to Login</a>
</body>
</html>
