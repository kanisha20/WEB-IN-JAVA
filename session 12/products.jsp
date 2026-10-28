
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flipkart Product Listing</title>
</head>
<body>

<h2>Available Products</h2>

<%
    String error = (String) request.getAttribute("error");
    List<Product> products =
        (List<Product>) request.getAttribute("products");
%>

<% if (error != null) { %>

    <p style="color:red"><%= error %></p>

<% } else if (products != null && !products.isEmpty()) { %>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>

        <% for (Product p : products) { %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td>₹<%= String.format("%.2f", p.getPrice()) %></td>
        </tr>
        <% } %>
    </table>

<% } else { %>

    <p>No products available.</p>

<% } %>

</body>
</html>
