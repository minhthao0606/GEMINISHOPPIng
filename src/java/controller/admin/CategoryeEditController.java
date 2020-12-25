package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category/edit"})
public class CategoryeEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Category category = cateService.get(Integer.parseInt(id));
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/edit-category.jsp");
        dispatcher.forward(request, response);
    }
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        cateService.edit(category);
        response.sendRedirect(request.getContextPath() + "/admin/category/list");

    }
}
