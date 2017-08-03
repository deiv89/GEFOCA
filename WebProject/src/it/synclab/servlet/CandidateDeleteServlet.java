package it.synclab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.synclab.business.Candidate;
import it.synclab.business.CandidateFactory;
import it.synclab.business.Candidate_Languages;
import it.synclab.business.Candidate_Skills;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Language;
import it.synclab.business.Origin;
import it.synclab.business.Skills;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
import it.synclab.service.ICandidateService;
import it.synclab.service.IEvaluationFormService;
import it.synclab.service.IOriginService;
import it.synclab.service.ISkillsService;

@WebServlet("/CandidateDeleteServlet")
public class CandidateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		String candidateSurname = request.getParameter("surname");
		int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
		int idOrigin = Integer.parseInt(request.getParameter("idOrigin"));
		
		ICandidateService candidateService = CandidateFactory.getJPACandidate();
		IEvaluationFormService efService = CandidateFactory.getJPAEvaluationForm();
		ISkillsService skillService = CandidateFactory.getJPASkills();
		IOriginService originService = CandidateFactory.getJPAOrigin();
		try {

			candidateService.delete(idCandidate);
			efService.delete(idCandidate);
			efService.deleteCandidateLanguages(idCandidate);
			skillService.delete(idCandidate);
			originService.delete(idOrigin);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "ERRORE: Eliminazione candidato non riuscita! " + e);
			request.getRequestDispatcher("/candidateDelete.jsp").forward(request, response);
		}
		request.setAttribute("message", "Candidato " + candidateSurname.toUpperCase() + " eliminato con successo!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/CandidateListServlet");
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String candidateSurname = request.getParameter("surname");
		int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
		int idOrigin = Integer.parseInt(request.getParameter("idOrigin"));

		try {
			ICandidateService candidateService = CandidateFactory.getJPACandidate();
			Candidate candidate = new Candidate();
			candidate = candidateService.read(idCandidate);

			IEvaluationFormService efService = CandidateFactory.getJPAEvaluationForm();
			ArrayList<Language> languagesList = new ArrayList<Language>();
			languagesList = efService.getLanguagesList();
			EvaluationForm currentEform = efService.read(idCandidate);
			

			ISkillsService skillService = CandidateFactory.getJPASkills();
			ArrayList<Skills> skillsList = new ArrayList<Skills>();
			skillsList = skillService.getSkillsList();
			ArrayList<Candidate_Skills> candidateSkills = skillService.read(idCandidate);
			ArrayList<Candidate_Languages> spokenLanguages = efService.getSpokenLanguages(idCandidate);

			IOriginService originService = CandidateFactory.getJPAOrigin();
			Origin currentOrigin = new Origin();
			currentOrigin = originService.read(idOrigin);

			request.setAttribute("candidate", candidate);
			request.setAttribute("surname", candidateSurname);
			request.setAttribute("languagesList", languagesList);
			request.setAttribute("evaluationForm", currentEform);
			request.setAttribute("spokenLanguages", spokenLanguages);
			request.setAttribute("skillsList", skillsList);
			request.setAttribute("candidateSkills", candidateSkills);
			request.setAttribute("origin", currentOrigin);

			request.getRequestDispatcher("/candidateDelete.jsp").forward(request, response);

		} catch (ClassNotFoundException | EmptyCandidateListException | SQLException | CandidateNotFoundException e) {
			e.printStackTrace();
		}

	}
	
}
