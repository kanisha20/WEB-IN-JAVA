
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial;
            background: #f2f5f9;
        }
        .login-box {
            width: 320px;
            margin: 60px auto;
            padding: 25px;
            background: white;
            border-radius: 10px;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #2874f0;
            color: white;
            border: none;
        }
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2>Login</h2>

    <% if (request.getAttribute("loginError") != null) { %>
        <p class="error">
            <%= request.getAttribute("loginError") %>
        </p>
    <% } %>

    <form action="LoginServlet" method="post">
        <input type="text" name="username"
               placeholder="Enter Username" required>

        <input type="password" name="password"
               placeholder="Enter Password" required>

        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>
