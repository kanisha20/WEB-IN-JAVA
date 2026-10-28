
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlaylistServlet")
public class PlaylistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>My Spotify Playlists</title></head>");
        out.println("<body style='font-family:Arial;background:#f4f4f4;padding:30px;'>");
        out.println("<h1 style='color:#1DB954;'>My Favorite Spotify Playlists</h1>");
        out.println("<ol>");
        out.println("<li>Bollywood Hits</li>");
        out.println("<li>Love Songs</li>");
        out.println("<li>Chill Vibes</li>");
        out.println("</ol>");
        out.println("</body></html>");
    }
}
