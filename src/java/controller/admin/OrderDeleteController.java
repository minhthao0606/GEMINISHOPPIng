package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartItemService;
import service.impl.CartServiceItemImpl;

@WebServlet(urlPatterns = "/admin/order/delete")
public class OrderDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartItemService cartItemService = new CartServiceItemImpl();
        String id = request.getParameter("id");
        cartItemService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/order/list");

    }

}
