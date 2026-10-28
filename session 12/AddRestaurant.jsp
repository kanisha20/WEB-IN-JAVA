
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Restaurant</title>
    <style>
        body {
            font-family: Arial;
            background: #fff4f0;
        }
        .box {
            width: 350px;
            margin: 60px auto;
            padding: 25px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 0 10px #ddd;
        }
        h2 {
            color: #e23744;
            text-align: center;
        }
        input, select, button {
            width: 100%;
            box-sizing: border-box;
            padding: 11px;
            margin: 10px 0;
        }
        button {
            background: #e23744;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>Add Restaurant</h2>

    <% if (request.getAttribute("message") != null) { %>
        <p style="color:green">
            <%= request.getAttribute("message") %>
        </p>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <form action="AddRestaurantServlet" method="post">
        <input type="text" name="name"
               placeholder="Restaurant Name" required>

        <select name="cuisine" required>
            <option value="">Select Cuisine</option>
            <option value="Indian">Indian</option>
            <option value="Chinese">Chinese</option>
            <option value="Italian">Italian</option>
            <option value="Mexican">Mexican</option>
            <option value="South Indian">South Indian</option>
        </select>

        <button type="submit">Add Restaurant</button>
    </form>
</div>

</body>
</html>
