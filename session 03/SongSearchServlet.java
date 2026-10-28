
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SongSearchServlet")
public class SongSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        String song = request.getParameter("song");
        String artist = request.getParameter("artist");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Song Search Results</h2>");
        out.println("<p>Searching for " + song
                    + " by " + artist + "</p>");
        out.println("</body></html>");
    }
}
