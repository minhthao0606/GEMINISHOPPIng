package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;
import model.User;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/admin/*")
public class SecurityFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resq = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("account");

        if (user != null && user.getRoleId() == 1 && user.isActive() == true) { // it's admin account
            chain.doFilter(request, response);
            return; 
        } else {
            resq.sendRedirect(req.getContextPath() + "/logout");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
