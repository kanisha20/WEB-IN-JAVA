
package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
        "jdbc:mysql://localhost:3306/eventdb";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String sql = "SELECT username FROM users "
                   + "WHERE username = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        // Prevent session fixation on login
                        HttpSession oldSession = request.getSession(false);

                        if (oldSession != null) {
                            oldSession.invalidate();
                        }

                        HttpSession session = request.getSession(true);
                        session.setAttribute("username",
                                             rs.getString("username"));
                        session.setMaxInactiveInterval(30 * 60);

                        response.sendRedirect(
                            request.getContextPath() + "/Home.jsp");
                    } else {
                        request.setAttribute("error",
                                             "Invalid username or password.");

                        request.getRequestDispatcher("/Login.jsp")
                               .forward(request, response);
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {

            getServletContext().log("Login failed due to server error", e);

            request.setAttribute("error",
                "Unable to log in right now. Please try again.");

            request.getRequestDispatcher("/Login.jsp")
                   .forward(request, response);
        }
    }
}
