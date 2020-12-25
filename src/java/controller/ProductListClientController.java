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


@WebServlet(urlPatterns = {"/product/list"})
public class ProductListClientController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        CategoryService cateService = new CategoryServiceImpl();
        request.setAttribute("productList", productService.getAll());
        request.getRequestDispatcher("/view/client/view/product-list.jsp").forward(request, response);
    }

}
