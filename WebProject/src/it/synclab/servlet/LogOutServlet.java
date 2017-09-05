package it.synclab.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.synclab.business.CandidateFactory;
import it.synclab.business.Movement;
import it.synclab.business.User;
import it.synclab.service.IMovementsLogService;
import it.synclab.service.IUserService;

@WebServlet("/LogOut")
public class LogOutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final String action = "Log Out";
	private final String description = "logged Out";
	
	
	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String username = (String) request.getParameter("user");
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("user");
			session.invalidate();
		}
		try{
			ArrayList<User> userlist = new ArrayList<User>();
			IUserService userService = CandidateFactory.getJPAUser();
			userlist = userService.read(username);
			IMovementsLogService logService = CandidateFactory.getJPAMovement();
			Movement mov = new Movement();
			mov.setIdUser(userlist.get(0));
			mov.setAction(action);
			mov.setDescription(username + " " + description);
			logService.create(mov);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		request.setAttribute("message", "You are successfully logged out!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");


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
