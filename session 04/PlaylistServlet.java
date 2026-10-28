
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PlaylistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String genre = getServletConfig()
                           .getInitParameter("defaultGenre");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Welcome to Your Playlist!</h2>");
        out.println("<p>Default Playlist Genre: "
                    + genre + "</p>");
        out.println("</body></html>");
    }
}
