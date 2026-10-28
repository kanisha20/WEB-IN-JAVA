
package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Event;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EventListServlet")
public class EventListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
        "jdbc:mysql://localhost:3306/eventdb";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Event> events = new ArrayList<>();

        String sql = "SELECT id, username, title, event_date, description "
                   + "FROM events ORDER BY event_date ASC, id DESC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Event event = new Event();

                    event.setId(rs.getInt("id"));
                    event.setUsername(rs.getString("username"));
                    event.setTitle(rs.getString("title"));
                    event.setEventDate(
                        rs.getDate("event_date").toString());
                    event.setDescription(rs.getString("description"));

                    events.add(event);
                }
            }

            request.setAttribute("events", events);

        } catch (ClassNotFoundException | SQLException e) {
            getServletContext().log("Event retrieval failed", e);

            request.setAttribute("error",
                "Unable to load events. Please try again later.");
        }

        request.getRequestDispatcher("/EventsList.jsp")
               .forward(request, response);
    }
}
