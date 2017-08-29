package it.synclab.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.synclab.business.Candidate;
import it.synclab.business.CandidateFactory;
import it.synclab.exception.EmptyCandidateListException;
import it.synclab.service.ICandidateService;

@WebServlet("/CandidateListServlet")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");

			Object message = request.getAttribute("message");
			String username = (String) request.getAttribute("username");
			ICandidateService candidateService = CandidateFactory.getJPACandidate();
			ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
			try {
				candidateList = candidateService.getCandidateList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EmptyCandidateListException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (candidateList.size() == 0) {
				request.setAttribute("message", "NESSUNA VOCE PRESENTE!");
				request.setAttribute("username", username);
				request.getRequestDispatcher("/candidateService.jsp").forward(request, response);
			}

			request.setAttribute("candidateList", candidateList);
			request.setAttribute("message", message);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/candidateService.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Devi effettuare il Log In");
			request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");

			Object message = request.getAttribute("message");
			String username = (String) request.getAttribute("username");
			ICandidateService candidateService = CandidateFactory.getJPACandidate();
			ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
			try {
				candidateList = candidateService.getCandidateList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EmptyCandidateListException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (candidateList.size() == 0) {
				request.setAttribute("message", "NESSUNA VOCE PRESENTE!");
				request.setAttribute("username", username);
				request.getRequestDispatcher("/candidateService.jsp").forward(request, response);
			}

			request.setAttribute("candidateList", candidateList);
			request.setAttribute("message", message);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/candidateService.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Devi effettuare il Log In");
			request.getRequestDispatcher("/loginSignup.jsp").forward(request, response);
		}

	}

}
