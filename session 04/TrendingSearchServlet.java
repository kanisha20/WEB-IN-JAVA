
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TrendingSearchServlet extends HttpServlet {

    @Override
    public void init() {
        ServletContext context = getServletContext();

        synchronized (context) {
            if (context.getAttribute("trendingKeywords") == null) {

                List<String> keywords =
                    new CopyOnWriteArrayList<>();

                keywords.add("Shoes");
                keywords.add("Smartphones");
                keywords.add("Watches");
                keywords.add("Headphones");

                context.setAttribute("trendingKeywords", keywords);
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        ServletContext context = getServletContext();

        List<String> keywords =
            (List<String>) context.getAttribute("trendingKeywords");

    
        String newKeyword = request.getParameter("keyword");

        if (newKeyword != null && !newKeyword.trim().isEmpty()) {
            String value = newKeyword.trim();

            synchronized (keywords) {
                boolean exists = keywords.stream()
                    .anyMatch(k -> k.equalsIgnoreCase(value));

                if (!exists) {
                    keywords.add(value);
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Trending Searches</h2>");
        out.println("<ul>");

        for (String keyword : keywords) {
            out.println("<li>" + escapeHtml(keyword) + "</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
