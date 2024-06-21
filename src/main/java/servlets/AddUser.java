package servlets;

import java.io.IOException;

import beans.User;
import dao.DaoFactory;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW_ADD_USERS = "/WEB-INF/addUser.jsp";
    private UserDao userDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_ADD_USERS).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (lastName.isEmpty() || firstName.isEmpty() || login.isEmpty() || password.isEmpty()) {
            doGet(request, response);
        } else {
            userDao.add(new User(lastName, firstName, login, password));
            response.sendRedirect("/user");
        }
    }

}
