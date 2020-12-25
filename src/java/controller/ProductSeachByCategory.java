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

@WebServlet(urlPatterns = "/product/category")
public class ProductSeachByCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String cate_id = request.getParameter("cate_id");
        request.setAttribute("productSeachByCategory", productService.seachByCategory(Integer.parseInt(cate_id)));
        request.getRequestDispatcher("/view/client/view/productSeachByCategory.jsp").forward(request, response);

    }
}
