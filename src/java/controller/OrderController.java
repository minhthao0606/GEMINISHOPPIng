package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import tools.SendMail;
import util.RandomUUID;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {

    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CartItemService cartItemService = new CartServiceItemImpl();
        long time = System.currentTimeMillis();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("account");
        User buyer = (User) obj;
        Cart cart = new Cart();
        cart.setBuyer(buyer);
        cart.setBuyDate(new java.sql.Date(time));
        cart.setId(RandomUUID.getRandomID());
        cartService.insert(cart);

        Object objCart = session.getAttribute("cart");
        if (objCart != null) { // cart is not empty
            Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;
            for (CartItem cartItem : map.values()) {
                cartItem.setCart(cart);
                cartItem.setId(RandomUUID.getRandomID());
                SendMail sm = new SendMail();
                sm.sendMail(cart.getBuyer().getEmail(), "GEMINISHOPPING", "Payment success. We will contact you soon ! ");
                cartItemService.insert(cartItem);
            }
        }
        session.removeAttribute("cart");
        response.sendRedirect(request.getContextPath() + "/welcome");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
