package controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.User;
import model.CartItem;
import service.CartItemService;
import service.CartService;
import service.UserService;
import service.impl.CartServiceImpl;
import service.impl.CartServiceItemImpl;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin/order/list"})

public class OrderListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartItemService cartItemService = new CartServiceItemImpl();
        CartService cartService = new CartServiceImpl();
        request.setAttribute("listCartItem", cartItemService.getAll());
        request.getRequestDispatcher("/view/admin/view/list-order.jsp").forward(request, response);
    }

}
