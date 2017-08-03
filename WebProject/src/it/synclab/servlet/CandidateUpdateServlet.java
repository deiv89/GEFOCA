package it.synclab.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.synclab.business.Candidate;
import it.synclab.business.CandidateFactory;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
import it.synclab.service.ICandidateService;

@WebServlet("/CandidateUpdateServlet")
public class CandidateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		ICandidateService candidateService = CandidateFactory.getJPACandidate();
		Candidate candidate = new Candidate();
		Candidate currentCandidate = new Candidate();
		
		try {
			candidate.setName(request.getParameter("name"));
			candidate.setSurname(request.getParameter("surname"));
			candidate.setDateOfBirth(request.getParameter("dateOfBirth"));
			candidate.setQualification(request.getParameter("qualification"));
			candidate.setIdCandidate(Integer.parseInt(request.getParameter("idCandidate")));
			candidate.setIdOrigin(Integer.parseInt(request.getParameter("idOrigin")));

			candidateService.update(candidate);
			currentCandidate = candidateService.read(candidate.getIdCandidate());

		} catch (ClassNotFoundException | SQLException | CandidateNotFoundException | EmptyCandidateListException e) {
			e.printStackTrace();
			request.setAttribute("message", e);
			request.getRequestDispatcher("/candidateUpdate.jsp").forward(request, response);
		}

		if (currentCandidate != null) {
			request.setAttribute("message", "Candidato " + candidate.getSurname() + " salvato con successo!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/CandidateDetailServlet");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "ERRORE: Modifica candidato non riuscita");
			request.getRequestDispatcher("/candidateUpdate.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		//String candidateSurname = request.getParameter("surname");
		int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));

		ICandidateService candidateService = CandidateFactory.getJPACandidate();
		Candidate candidate = new Candidate();
		
		try {
			candidate = candidateService.read(idCandidate);
		} catch (ClassNotFoundException | EmptyCandidateListException | SQLException | CandidateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("candidate", candidate);
		
		request.getRequestDispatcher("/candidateUpdate.jsp").forward(request, response);

	}

}
