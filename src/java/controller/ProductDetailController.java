package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/product/detail")
public class ProductDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        String id = request.getParameter("id");
        request.setAttribute("categories",categoryService.getAll());
        request.setAttribute("product", productService.get(Integer.parseInt(id)));
        request.getRequestDispatcher("/view/client/view/product-detail.jsp").forward(request, response);
    }

}
