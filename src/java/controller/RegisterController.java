package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

import service.UserService;
import service.impl.UserServiceImpl;
import tools.SendMail;
import util.Constant;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {// still login
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		} 
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {  // remember username
					session = request.getSession(true);
					session.setAttribute("username", cookie.getValue());
					response.sendRedirect(request.getContextPath() + "/admin");
					return;
				}
			}
		}
		request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserService service = new UserServiceImpl();
		String message = "";

		if (service.checkExistEmail(email)) {
			message = "Email already exist!";
			request.setAttribute("alert", message);
			request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
			return;
		}
		if (service.checkExistUsername(username)) {
			message = "Username already exist!";
			request.setAttribute("alert", message);
			request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
			return;
		}

		boolean isSuccess = service.register(username, password, email);

		if (isSuccess) {
			SendMail sm= new SendMail();
			sm.sendMail(email, "GEMINISHOPPING", "Welcome to GEMINI. This is best website shopping for man. Please Login to use service. Thanks!");
			request.setAttribute("alert", message);
                        User user = new User(email, username, password);
                        user.setActive(true);
                        user.setRoleId(2);
                        user.setAvatar("");
                        service.insert(user);
                        response.sendRedirect(request.getContextPath() + "/login");
		} else {
			message = "System error!";
			request.setAttribute("alert", message);
			request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
		}
	}

}
