package servlets;

import java.io.IOException;
import java.util.List;

import beans.User;
import dao.DaoFactory;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_INDEX_USERS = "/WEB-INF/index.jsp";
	private UserDao userDao;

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.userDao = daoFactory.getUserDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUsers = userDao.list();
		request.setAttribute("listUsers", listUsers);
		request.getRequestDispatcher(VIEW_INDEX_USERS).forward(request, response);
	}
}
