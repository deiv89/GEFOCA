package it.synclab.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.synclab.business.CandidateFactory;
import it.synclab.business.Movement;
import it.synclab.business.User;
import it.synclab.service.IMovementsLogService;
import it.synclab.service.IUserService;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final String action = "Registrazione";
	private final String description = "Nuova registrazione";

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("signUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		//Object message = request.getAttribute("message");
		IUserService userService = CandidateFactory.getJPAUser();
		User user = new User();
		ArrayList<User> userList = new ArrayList<User>();
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String checkedPassword = request.getParameter("passwordCheck");
		try {
			if (username.isEmpty() || username == null) {
				request.setAttribute("messageUsername", "Username non valido ");
				// request.getRequestDispatcher("/signUp.jsp").forward(request,
				// response);
			}
			if (password.isEmpty() || password == null) {
				request.setAttribute("messagePassword", "Password non valida ");
				// request.getRequestDispatcher("/signUp.jsp").forward(request,
				// response);
			}
			userList = userService.read(capitalise(username));
			if (userList.size() == 0 || userList == null) {
				if (password.equals(checkedPassword)) {
					user.setUserName(capitalise(username));
					user.setPassWord(password);
					userService.create(user);
				} else {
					request.setAttribute("messagePassword", "La password inserita non corrisponde! ");
					request.getRequestDispatcher("/signUp.jsp").forward(request, response);
				}
			}
			if (userList.size() > 0) {
				request.setAttribute("messageUsername", "Username inserito già esistente");
				request.getRequestDispatcher("/signUp.jsp").forward(request, response);
			}
		} catch (NoResultException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "Username e Password non validi");
			request.getRequestDispatcher("/signUp.jsp").forward(request, response);
		} 
		ArrayList<User> currentUser = new ArrayList<User>();
		currentUser = userService.read(capitalise(username));
		if (currentUser != null && currentUser.size() > 0) {
			try{
				IMovementsLogService logService = CandidateFactory.getJPAMovement();
				Movement mov = new Movement();
				mov.setIdUser(currentUser.get(0));
				mov.setAction(action);
				mov.setDescription(description);
				logService.create(mov);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			request.setAttribute("username", currentUser.get(0).getUserName());
			request.setAttribute("message", "Registrazione avvenuta con successo!");
			request.setAttribute("fromRegistration", "yes");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "ERRORE: Registrazione Utente non riuscita");
			request.getRequestDispatcher("/signUp.jsp").forward(request, response);
		}
	}

	public static String capitalise(final String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}

}
