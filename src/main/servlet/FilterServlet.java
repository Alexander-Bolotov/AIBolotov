package src.main.servlet;

import com.sun.org.apache.bcel.internal.generic.IFNONNULL;
import src.main.model.User;
import src.main.service.Service;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/admin", "/user", "/unknown"})
public class FilterServlet implements Filter {
    private FilterConfig filterConfig = null;
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String act = filterConfig.getInitParameter("active");
        if (act != null) {
            active = (act.toUpperCase().equals("TRUE"));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Service service = Service.getInstance();

        final String name = httpServletRequest.getParameter("name");
        final String password = httpServletRequest.getParameter("password");
        final HttpSession httpSession = httpServletRequest.getSession();

        if (httpSession != null && httpSession.getAttribute("name") != null && httpSession.getAttribute("password") != null) {
            final String role = (String) httpSession.getAttribute("role");
            moveToPage(httpServletRequest, httpServletResponse, role);
        } else if (service.userIsExist(name, password)){
            final String role = (String) service.getRoleByName(name);

            httpServletRequest.getSession().setAttribute("name", name);
            httpServletRequest.getSession().setAttribute("password", password);
            httpServletRequest.getSession().setAttribute("role", role);

            moveToPage(httpServletRequest, httpServletResponse, role);
        } else {
            String role = "Unknown";
            moveToPage(httpServletRequest, httpServletResponse, role);
        }
    }

    private void moveToPage(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final String role) throws ServletException, IOException {
        if (role.equals("Admin")){
            httpServletRequest.getRequestDispatcher("admin.jsp").forward(httpServletRequest, httpServletResponse);
        } else if(role.equals("User")){
            httpServletRequest.getRequestDispatcher("user.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }


    @Override
    public void destroy() {
        filterConfig = null;
    }
}