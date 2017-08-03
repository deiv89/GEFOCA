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

@WebServlet("/CandidateCreateServlet")
public class CandidateCreateServlet extends HttpServlet {
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

			candidateService.create(candidate);
			currentCandidate = candidateService.read(candidate.getIdCandidate());

		} catch (ClassNotFoundException | SQLException | CandidateNotFoundException | EmptyCandidateListException e) {
			e.printStackTrace();
			request.setAttribute("message", e);
			request.getRequestDispatcher("/candidateCreate.jsp").forward(request, response);
		}

		if (currentCandidate.getSurname() != null) {
			request.setAttribute("message", "Candidato " + candidate.getSurname() + " salvato con successo!");
			request.setAttribute("idCandidate", currentCandidate.getIdCandidate());
			request.setAttribute("surname", currentCandidate.getSurname());
			request.setAttribute("firstTime", "yes");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/EvaluationCreateServlet");
			rd.forward(request, response);
			
			//request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "ERRORE: Creazione candidato non riuscita");
			request.getRequestDispatcher("/candidateCreate.jsp").forward(request, response);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/candidateCreate.jsp").forward(request, response);
	}

}

