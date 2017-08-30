package it.synclab.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.synclab.business.Candidate;
import it.synclab.business.CandidateFactory;
import it.synclab.service.ICandidateService;

@WebServlet("/CandidateSearchServlet")
public class CandidateSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		Object message = request.getAttribute("message");
		String username = (String) request.getAttribute("username");
		Candidate candidate = new Candidate();
		candidate.setName(capitalise(request.getParameter("name")));
		candidate.setSurname(capitalise(request.getParameter("surname")));
		ICandidateService candidateService = CandidateFactory.getJPACandidate();
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		candidateList = (ArrayList<Candidate>) candidateService.getCandidatesByFilter(candidate);

		if (candidateList.size() == 0) {
			request.setAttribute("message", "NESSUNA VOCE PRESENTE!");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/candidateService.jsp").forward(request, response);
		}

		request.setAttribute("candidateList", candidateList);
		request.setAttribute("username", username);
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("/candidateService.jsp").forward(request, response);


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}
	
	public static String capitalise(final String word) {
		if(word.isEmpty() || word == null){
			return "";
		}
	    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}

}
