package it.synclab.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.synclab.business.CandidateFactory;
import it.synclab.business.Candidate_Languages;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Language;
import it.synclab.service.IEvaluationFormService;
import it.synclab.utilities.ParameterUtility;

@WebServlet("/EvaluationCreateServlet")
public class EvaluationCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		if (request.getAttribute("firstTime") != null) {
			int idCandidate = (Integer) request.getAttribute("idCandidate");
			String user = (String) request.getAttribute("username");
			String surname = request.getParameter("surname");
			IEvaluationFormService efService = CandidateFactory.getJPAEvaluationForm();
			ArrayList<Language> languagesList = new ArrayList<Language>();
			try {
				languagesList = efService.getLanguagesList();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", e);
				request.setAttribute("username", user);
				request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
			}
			request.setAttribute("username", user);
			request.setAttribute("languagesList", languagesList);
			request.setAttribute("idCandidate", idCandidate);
			request.setAttribute("surname", surname);
			request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);

		} else {

			int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
			String surname = request.getParameter("surname");
			String user = (String) request.getAttribute("user");
			IEvaluationFormService efService = CandidateFactory.getJPAEvaluationForm();
			EvaluationForm eform = new EvaluationForm();
			EvaluationForm currentEform = new EvaluationForm();
			ArrayList<Candidate_Languages> spokenLanguages = new ArrayList<Candidate_Languages>();
			Candidate_Languages lang;
			ArrayList<Language> languagesList = new ArrayList<Language>();
			try {
				languagesList = efService.getLanguagesList();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("username", user);
				request.setAttribute("message", e);
				request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
			}

			try {
				eform.setInterviewerName(request.getParameter("interviewerName"));
				// eform.setLevelPresence(Integer.parseInt(request.getParameter("levelPresence")));
				eform.setLevelPresence(ParameterUtility.getIntValue(request, "levelPresence", 0));
				eform.setLevelDynamicity(ParameterUtility.getIntValue(request, "levelDynamicity", 0));
				eform.setLevelComunication(ParameterUtility.getIntValue(request, "levelComunication", 0));
				eform.setExperience(request.getParameter("experience"));
				eform.setMotivazioni(request.getParameter("motivation"));
				eform.setTransfer(request.getParameter("transfer"));
				eform.setAvailability(request.getParameter("availability"));

				// <%=request.getParameter("item_" + count.index)%>
				for (int i = 0; i < languagesList.size(); i++) {
					lang = new Candidate_Languages();
					lang.setIdCandidate(idCandidate);
					lang.setIdLanguage(languagesList.get(i).getIdLanguage());
					lang.setLanguageLevel(ParameterUtility.getIntValue(request,
							"languageLevel_" + languagesList.get(i).getIdLanguage(), 0));
					spokenLanguages.add(lang);
				}

				eform.setCurrentPay(ParameterUtility.getDoubleValue(request, "currentPay", 0.0));
				eform.setRenumeration_required(ParameterUtility.getDoubleValue(request, "renumerationRequired", 0.0));
				eform.setIdCandidate(idCandidate);

				IEvaluationFormService eformService = CandidateFactory.getJPAEvaluationForm();
				eformService.create(eform);
				eformService.persistSpokenLang(spokenLanguages);
				currentEform = eformService.read(idCandidate);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("username", user);
				request.setAttribute("message", e);
				request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
			}

			if (currentEform != null) {
				request.setAttribute("username", user);
				request.setAttribute("message",
						"Scheda di valutazione ID Candidato " + idCandidate + " salvata con successo!");
				request.setAttribute("languagesList", languagesList);
				request.setAttribute("firstTime", "yes");
				request.setAttribute("idCandidate", idCandidate);
				request.setAttribute("surname", surname);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SkillsCreateServlet");
				rd.forward(request, response);
			} else {
				request.setAttribute("username", user);
				request.setAttribute("message", "ERRORE: Creazione Scheda di valutazione non riuscita");
				request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int idCandidate = (Integer) request.getAttribute("idCandidate");
		String user = (String) request.getAttribute("username");
		IEvaluationFormService efService = CandidateFactory.getJPAEvaluationForm();
		ArrayList<Language> languagesList = new ArrayList<Language>();
		try {
			languagesList = efService.getLanguagesList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("username", user);
			request.setAttribute("message", e);
			request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
		}
		request.setAttribute("username", user);
		request.setAttribute("languagesList", languagesList);
		request.setAttribute("idCandidate", idCandidate);
		request.getRequestDispatcher("/evaluationFormCreate.jsp").forward(request, response);
	}

}
