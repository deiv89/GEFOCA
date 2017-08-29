package it.synclab.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOut")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("name");
			session.invalidate();
		}

		request.setAttribute("message", "You are successfully logged out!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage");
		rd.forward(request, response);

		// out.print("You are successfully logged out!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("name");
			session.invalidate();
		}

		request.setAttribute("message", "You are successfully logged out!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage");
		rd.forward(request, response);

	}

}
