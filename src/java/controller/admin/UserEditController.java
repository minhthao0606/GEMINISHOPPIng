package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin/user/edit"})
public class UserEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userService.get(id));
        request.getRequestDispatcher("/view/admin/view/edit-user.jsp").forward(request, response);
    }
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    user.setId(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("email")) {
                    user.setEmail(item.getString());
                } else if (item.getFieldName().equals("username")) {
                    user.setUsername(item.getString());
                } else if (item.getFieldName().equals("password")) {
                    user.setPassword(item.getString());
                } else if (item.getFieldName().equals("role")) {
                    user.setRoleId(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("avatar")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File("D:/Code/JavaWeb/GEMINISHOPPING/image/" + fileName);
                        item.write(file);
                        user.setAvatar(fileName);
                    } else {
                        user.setAvatar(null);
                    }
                }
            }

            userService.edit(user);
            response.sendRedirect(request.getContextPath() + "/admin/user/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/admin/user/list");
        }

    }
}
