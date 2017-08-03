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
import it.synclab.business.Candidate_Skills;
import it.synclab.business.Language;
import it.synclab.business.Skills;
import it.synclab.service.ISkillsService;
import it.synclab.utilities.ParameterUtility;

@WebServlet("/SkillsUpdateServlet")
public class SkillsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

			int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
			String surname = request.getParameter("surname");
			int idOrigin = Integer.parseInt(request.getParameter("idOrigin"));
			ISkillsService skillService = CandidateFactory.getJPASkills();
			ArrayList<Skills> skillsList = new ArrayList<Skills>();
			ArrayList<Candidate_Skills> candidateSkills = new ArrayList<Candidate_Skills>();
			Candidate_Skills skills;
			try {
				skillsList = skillService.getSkillsList();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", e);
				request.getRequestDispatcher("/skillsFormUpdate.jsp").forward(request, response);
			}
			for (int i = 0; i < skillsList.size(); i++) {
				skills = new Candidate_Skills();
				skills.setIdCandidate(idCandidate);
				skills.setIdSkill(skillsList.get(i).getIdSkill());
				skills.setValuationLevel(
						ParameterUtility.getIntValue(request, "valuationLevel_" + skillsList.get(i).getIdSkill(), 0));
				candidateSkills.add(skills);
			}
			try {
				skillService.update(candidateSkills, idCandidate);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", e);
				request.getRequestDispatcher("/skillsFormUpdate.jsp").forward(request, response);
			}

			try {
				ArrayList<Candidate_Skills> currentSkills;
				currentSkills = skillService.read(idCandidate);
				if (currentSkills != null) {
					request.setAttribute("message",
							"Skills Matrix ID Candidato " + idCandidate + " salvata con successo!");
					request.setAttribute("skillsList", skillsList);
					request.setAttribute("firstTime", "yes");
					request.setAttribute("idCandidate", idCandidate);
					request.setAttribute("idOrigin", idOrigin);
					request.setAttribute("surname", surname);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/CandidateDetailServlet");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "ERRORE: Creazione Skills Matrix non riuscita");
					request.getRequestDispatcher("/skillsFormUpdate.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
		int idOrigin = Integer.parseInt(request.getParameter("idOrigin"));
		String surname = request.getParameter("surname");
		ISkillsService skillService = CandidateFactory.getJPASkills();
		ArrayList<Skills> skillsList = new ArrayList<Skills>();
		ArrayList<Candidate_Skills> candidateSkills = new ArrayList<Candidate_Skills>();
		try {
			skillsList = skillService.getSkillsList();
			candidateSkills = skillService.read(idCandidate);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e);
			request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
		}
		request.setAttribute("skillsList", skillsList);
		request.setAttribute("surname", surname);
		request.setAttribute("idCandidate", idCandidate);
		request.setAttribute("idOrigin", idOrigin);
		request.setAttribute("candidateSkills", candidateSkills);
		request.getRequestDispatcher("/skillsFormUpdate.jsp").forward(request, response);
	}

}
