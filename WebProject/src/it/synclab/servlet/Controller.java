package it.synclab.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.synclab.business.CandidateFactory;
import it.synclab.business.User;
import it.synclab.service.IUserService;

@WebServlet("/WelcomePage")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("loginSignup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		if (request.getAttribute("fromRegistration") != null) {
			Object message = request.getAttribute("message");
			String username = (String) request.getAttribute("username");
			request.setAttribute("message", "Benvenuto " + username + " " + message);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginSignup.jsp");
			rd.forward(request, response);
		} else {
			//Object message = request.getAttribute("message");
			IUserService userService = CandidateFactory.getJPAUser();
			ArrayList<User> userList = new ArrayList<User>();
			String username = request.getParameter("userName");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();
			session.setAttribute("user", capitalise(username));
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userCookie = new Cookie("user", username);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);

			try {
				if (username.isEmpty() || username == null) {
					request.setAttribute("messageUsername", "Username non valido");
					request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
				}
				if (password.isEmpty() || password == null) {
					request.setAttribute("messagePsw", "Password non valida");
					request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
				}
				userList = userService.read(username);
				if (userList.size() > 0) {
					if (userList.get(0).getPassWord().equals(password)) {
						request.setAttribute("username", userList.get(0).getUserName());
						request.setAttribute("welcomeMessage", "Benvenuto "+ userList.get(0).getUserName() + " nel portale Candidature");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/CandidateListServlet");
						rd.forward(request, response);
					} else {
						request.setAttribute("messagePsw", "Password non corretta");
						request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("messageUsername", "Username inserito inesistente");
					request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
				}
			} catch (NoResultException e) {
				e.printStackTrace();
				request.setAttribute("message", "Username e Password non validi");
				request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
			} catch (NullPointerException e) {
				e.printStackTrace();
				request.setAttribute("message", "Username e Password non validi");
				request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "Si è verificato un problema");
				request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
			}
		}

	}

	public static String capitalise(final String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}

}
