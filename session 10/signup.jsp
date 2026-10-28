
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>
    <style>
        body {
            font-family: Arial;
            background: #f2f5f9;
        }
        .form-box {
            width: 350px;
            margin: 60px auto;
            padding: 25px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #2874f0;
            color: white;
            border: none;
            cursor: pointer;
        }
        .error {
            color: red;
            font-size: 14px;
            margin: 3px 0 10px;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Sign Up</h2>

    <form action="SignupServlet" method="post">

        <label>Username:</label>
        <input type="text" name="username"
               value="<%= request.getAttribute("username") != null
                   ? request.getAttribute("username") : "" %>">

        <label>Email:</label>
        <input type="text" name="email"
               value="<%= request.getAttribute("email") != null
                   ? request.getAttribute("email") : "" %>">

        <% if (request.getAttribute("emailError") != null) { %>
            <div class="error">
                <%= request.getAttribute("emailError") %>
            </div>
        <% } %>

        <label>Password:</label>
        <input type="password" name="password">

        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>

        <button type="submit">Create Account</button>
    </form>

    <p>Already registered? <a href="login.jsp">Login</a></p>
</div>

</body>
</html>
