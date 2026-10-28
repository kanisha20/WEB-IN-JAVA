
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registered Products</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f5f9;
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #2874f0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background: #2874f0;
            color: white;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 18px;
            background: #2874f0;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>

<body>

<h2>Registered Products</h2>

<%
    List<Product> products =
        (List<Product>) session.getAttribute("products");
%>

<% if (products == null || products.isEmpty()) { %>

    <p>No products registered yet.</p>

<% } else { %>

<table>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price (₹)</th>
        <th>Category</th>
    </tr>

    <% for (Product p : products) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= String.format("%.2f", p.getPrice()) %></td>
        <td><%= p.getCategory() %></td>
    </tr>
    <% } %>

</table>

<% } %>

<a href="index.jsp">Add Another Product</a>

</body>
</html>
