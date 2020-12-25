package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/user/delete"})
public class UserDeleteController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserService userService = new UserServiceImpl();	
            String id = request.getParameter("id");
		userService.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath() + "/admin/user/list");
	}
}
