package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/product/seach")

public class ProductSeachByName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String name = request.getParameter("name");
        request.setAttribute("productSeachByName", productService.seachByName(name));
        request.getRequestDispatcher("/view/client/view/product-seach-by-name.jsp").forward(request, response);

    }
}
