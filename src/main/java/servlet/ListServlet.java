package servlet;

import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "list", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        UserService userService= ctx.getBean(UserService.class);
        List<User> users=userService.getAll();
        request.setAttribute("list",users);
        request.getRequestDispatcher("pages/list.jsp").forward(request,response);
    }
}
