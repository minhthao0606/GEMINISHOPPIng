package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category/delete"})
public class CategoryeDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService cateService = new CategoryServiceImpl();
        String id = request.getParameter("id");
        cateService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/category/list");
    }

}
