
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlaylistDetailsServlet")
public class PlaylistDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        String playlistId = request.getParameter("playlistId");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<h2>Playlist Details</h2>");
        out.println("<p>Playlist ID: " + playlistId + "</p>");
    }
}
