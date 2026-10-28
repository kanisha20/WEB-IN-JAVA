
package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
        "jdbc:mysql://localhost:3306/productdb";

    // Change these according to your MySQL configuration
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Product> products = new ArrayList<>();

        String name = request.getParameter("name");

        if (name == null) {
            name = "";
        }

        name = name.trim();

        String sql;

        if (name.isEmpty()) {
            sql = "SELECT id, name, price FROM products ORDER BY id";
        } else {
            sql = "SELECT id, name, price FROM products "
                + "WHERE LOWER(name) LIKE LOWER(?) ORDER BY id";
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                if (!name.isEmpty()) {
                    ps.setString(1, "%" + name + "%");
                }

                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {
                        Product p = new Product();

                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setPrice(rs.getDouble("price"));

                        products.add(p);
                    }
                }
            }

            request.setAttribute("products", products);

        } catch (ClassNotFoundException | SQLException e) {

            getServletContext().log(
                "Error retrieving products", e);

            request.setAttribute("error",
                "Unable to load products right now. "
                + "Please check the database connection and try again.");
        }

        request.setAttribute("searchName", name);

        request.getRequestDispatcher("/products.jsp")
               .forward(request, response);
    }
}
