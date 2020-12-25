package controller.admin;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;
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

import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin/product/edit"})
public class ProductEditController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("categories", categoryService.getAll());
        request.setAttribute("product", productService.get(Integer.parseInt(id)));
        request.getRequestDispatcher("/view/admin/view/edit-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);

            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    product.setId(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("name")) {
                    product.setName(item.getString());

                } else if (item.getFieldName().equals("cate")) {
                    product.setCategory(categoryService.get(item.getString()));
                } else if (item.getFieldName().equals("des")) {
                    product.setDes(item.getString());

                } else if (item.getFieldName().equals("price")) {
                    product.setPrice(Long.parseLong(item.getString()));
                } else if (item.getFieldName().equals("image")) {
                    if (item.getSize() > 0) {
                        final String dir = "D:\\Code\\JavaWeb\\GEMINISHOPPING\\image";
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(dir + "/" + fileName);
                        item.write(file);

                        product.setImage(fileName);

                    } else {

                        product.setImage(null);
                    }
                }
            }
            productService.edit(product);

            response.sendRedirect(request.getContextPath() + "/admin/product/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
