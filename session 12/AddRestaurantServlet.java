
package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
        "jdbc:mysql://localhost:3306/restaurantdb";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String cuisine = request.getParameter("cuisine");

        if (name == null || name.trim().isEmpty()
                || cuisine == null || cuisine.trim().isEmpty()) {

            request.setAttribute("error",
                                 "Please enter all details.");
            request.getRequestDispatcher("/AddRestaurant.jsp")
                   .forward(request, response);
            return;
        }

        String sql = "INSERT INTO restaurants (name, cuisine) VALUES (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, name.trim());
                ps.setString(2, cuisine.trim());

                ps.executeUpdate();
            }

            request.setAttribute("message",
                                 "Restaurant added successfully!");

        } catch (ClassNotFoundException | SQLException e) {

            getServletContext().log("Restaurant insertion failed", e);
            request.setAttribute("error",
                                 "Unable to add restaurant. Please try again.");
        }

        request.getRequestDispatcher("/AddRestaurant.jsp")
               .forward(request, response);
    }
}
