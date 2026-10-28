
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flipkart Product Registration</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f1f3f6;
        }

        .container {
            width: 380px;
            margin: 60px auto;
            padding: 25px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 3px 12px #ccc;
        }

        h2 {
            text-align: center;
            color: #2874f0;
        }

        input, select {
            width: 100%;
            padding: 11px;
            margin: 10px 0;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            border: none;
            background: #2874f0;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }

        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Product Registration</h2>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <% } %>

    <form action="AddProductServlet" method="post">

        <input type="text"
               name="name"
               placeholder="Enter Product Name"
               required>

        <input type="number"
               name="price"
               placeholder="Enter Product Price"
               min="0"
               step="0.01"
               required>

        <select name="category" required>
            <option value="">Select Category</option>
            <option value="Electronics">Electronics</option>
            <option value="Fashion">Fashion</option>
            <option value="Home">Home</option>
            <option value="Books">Books</option>
            <option value="Other">Other</option>
        </select>

        <button type="submit">Register Product</button>

    </form>

</div>

</body>
</html>
