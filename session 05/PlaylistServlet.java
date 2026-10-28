
package com.example;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlaylistServlet")
public class PlaylistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String playlistId = request.getParameter("playlistId");

        if (playlistId == null || playlistId.trim().isEmpty()) {
            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Playlist ID is required");
            return;
        }

        RequestDispatcher rd =
            request.getRequestDispatcher("/PlaylistDetailsServlet");

        rd.forward(request, response);
    }
}
