package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartItem;

@WebServlet(urlPatterns = {"/member/cart/remove"})
public class CartItemRemove extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("cart");//read data from session
        String pId = request.getParameter("pId");
        if (obj != null) {
            Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;
            map.remove(Integer.parseInt(pId));
            httpSession.setAttribute("cart", map);
        }
        response.sendRedirect(request.getContextPath() + "/member/cart");
    }
}
