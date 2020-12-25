package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.BestSellerDao;
import model.BestSeller;

import model.User;
import service.BestSellerService;
import service.impl.BestSellerServiceImpl;

@WebServlet(urlPatterns = "/admin")
public class welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        request.setAttribute("username", user.getUsername());
        BestSellerService bestSellerService = new BestSellerServiceImpl();
        request.setAttribute("data", bestSellerService.getBestSeller());
        request.setAttribute("dataBuyer", bestSellerService.getBestBuyer());
        request.getRequestDispatcher("/view/admin/view/index.jsp").forward(request, response);
    }

}
