
package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EventPostServlet")
public class EventPostServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
        "jdbc:mysql://localhost:3306/eventdb";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(
                request.getContextPath() + "/Login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String title = request.getParameter("title");
        String dateValue = request.getParameter("eventDate");
        String description = request.getParameter("description");

        if (title == null || title.trim().isEmpty()
                || dateValue == null || dateValue.trim().isEmpty()
                || description == null || description.trim().isEmpty()) {

            request.setAttribute("error", "Please fill all event fields.");
            request.getRequestDispatcher("/EventPost.jsp")
                   .forward(request, response);
            return;
        }

        try {
            LocalDate localDate = LocalDate.parse(dateValue);

            if (localDate.isBefore(LocalDate.now())) {
                request.setAttribute("error",
                    "Event date cannot be in the past.");

                request.getRequestDispatcher("/EventPost.jsp")
                       .forward(request, response);
                return;
            }

            String sql = "INSERT INTO events "
                       + "(username, title, event_date, description) "
                       + "VALUES (?, ?, ?, ?)";

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, title.trim());
                ps.setDate(3, Date.valueOf(localDate));
                ps.setString(4, description.trim());

                ps.executeUpdate();
            }

            response.sendRedirect(
                request.getContextPath() + "/EventListServlet");

        } catch (DateTimeParseException e) {
            request.setAttribute("error", "Please enter a valid event date.");

            request.getRequestDispatcher("/EventPost.jsp")
                   .forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            getServletContext().log("Event insertion failed", e);

            request.setAttribute("error",
                "Unable to save the event. Please try again.");

            request.getRequestDispatcher("/EventPost.jsp")
                   .forward(request, response);
        }
    }
}
