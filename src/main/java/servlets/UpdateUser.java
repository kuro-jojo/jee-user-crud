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

@WebServlet("/update")
public class UpdateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW_INDEX_USERS = "/WEB-INF/index.jsp";
    private static final String VIEW_UPDATE_USERS = "/WEB-INF/updateUser.jsp";
    private UserDao userDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("user", userDao.get(id));
            System.out.println(userDao.get(id));
            request.getRequestDispatcher(VIEW_UPDATE_USERS).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher(VIEW_INDEX_USERS).forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        int id = Integer.parseInt(request.getParameter("id"));
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (lastName.isEmpty() || firstName.isEmpty() || login.isEmpty() || password.isEmpty()) {
            doGet(request, response);
        } else {
            userDao.update(new User(id, lastName, firstName, login, password));
            response.sendRedirect("/user");
        }
    }

}
