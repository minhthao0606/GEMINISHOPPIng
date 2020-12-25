/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;
import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

/**
 *
 * @author gf63
 */
public class CartAddController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartAddController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartAddController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pId = request.getParameter("pId");
        String quantity = request.getParameter("quantity");
        Product product = productService.get(Integer.parseInt(pId));
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(Integer.parseInt(quantity));
        cartItem.setUnitPrice(product.getPrice());
        cartItem.setProduct(product);
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("cart");
        if (obj == null) {
            Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
            map.put(cartItem.getProduct().getId(), cartItem);
            httpSession.setAttribute("cart", map);
        } else {
            Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;

            CartItem existedCartItem = map.get(Integer.valueOf(pId));

            if (existedCartItem == null) {
                map.put(product.getId(), cartItem);
            } else {
                existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
            }

            httpSession.setAttribute("cart", map);
        }
        response.sendRedirect(request.getContextPath() + "/member/cart");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
