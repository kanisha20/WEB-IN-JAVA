
package com.example;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        String productId = request.getParameter("productId");

        if (productId == null ||
            !productId.matches("[A-Za-z0-9_-]+")) {
            response.sendError(400, "Invalid product ID");
            return;
        }

        List<String> items = new ArrayList<>();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cartItems".equals(cookie.getName())) {
                    String saved = URLDecoder.decode(
                        cookie.getValue(),
                        StandardCharsets.UTF_8);

                    if (!saved.isEmpty()) {
                        for (String item : saved.split(",")) {
                            if (item.matches("[A-Za-z0-9_-]+")) {
                                items.add(item);
                            }
                        }
                    }
                }
            }
        }

        if (!items.contains(productId)) {
            items.add(productId);
        }

        String value = String.join(",", items);

        Cookie cartCookie = new Cookie(
            "cartItems",
            URLEncoder.encode(value, StandardCharsets.UTF_8));

        cartCookie.setMaxAge(10 * 60); // 10 minutes
        cartCookie.setPath(request.getContextPath().isEmpty()
                           ? "/" : request.getContextPath());

        response.addCookie(cartCookie);
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("<h2>Item added to cart!</h2>");
        response.getWriter().println("<p>Cart items: "
                                     + items.size() + "</p>");
        response.getWriter().println(
            "<a href='" + response.encodeURL(
                request.getContextPath() + "/ViewCartServlet")
            + "'>View Cart</a>");
    }
}
