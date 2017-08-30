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
import it.synclab.business.Skills;
import it.synclab.service.ISkillsService;
import it.synclab.utilities.ParameterUtility;

@WebServlet("/SkillsCreateServlet")
public class SkillsCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		if (request.getAttribute("firstTime") != null) {
			int idCandidate = (Integer) request.getAttribute("idCandidate");
			String surname = request.getParameter("surname");
			String user = (String) request.getAttribute("username");
			ISkillsService skillService = CandidateFactory.getJPASkills();
			ArrayList<Skills> skillsList = new ArrayList<Skills>();
			try {
				skillsList = skillService.getSkillsList();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("username", user);
				request.setAttribute("message", e);
				request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
			}
			request.setAttribute("username", user);
			request.setAttribute("skillsList", skillsList);
			request.setAttribute("idCandidate", idCandidate);
			request.setAttribute("surname", surname);
			request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
		} else {
			int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
			String surname = request.getParameter("surname");
			String user = (String) request.getAttribute("username");
			ISkillsService skillService = CandidateFactory.getJPASkills();
			ArrayList<Skills> skillsList = new ArrayList<Skills>();
			ArrayList<Candidate_Skills> candidateSkills = new ArrayList<Candidate_Skills>();
			Candidate_Skills skills;
			try {
				skillsList = skillService.getSkillsList();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("username", user);
				request.setAttribute("message", e);
				request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
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
				ISkillsService skillsService = CandidateFactory.getJPASkills();
				skillsService.create(candidateSkills);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("username", user);
				request.setAttribute("message", e);
				request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
			}
			try {
				ArrayList<Candidate_Skills> currentSkills;
				ISkillsService skillsService = CandidateFactory.getSkillsService();
				currentSkills = skillsService.read(idCandidate);
				if (currentSkills != null) {
					request.setAttribute("username", user);
					request.setAttribute("message",
							"Skills Matrix ID Candidato " + idCandidate + " salvata con successo!");
					request.setAttribute("firstTime", "yes");
					request.setAttribute("idCandidate", idCandidate);
					request.setAttribute("surname", surname);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/OriginCreateServlet");
					rd.forward(request, response);
				} else {
					request.setAttribute("username", user);
					request.setAttribute("message", "ERRORE: Creazione Skills Matrix non riuscita");
					request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		int idCandidate = (Integer) request.getAttribute("idCandidate");
		String user = (String) request.getAttribute("username");
		ISkillsService skillService = CandidateFactory.getJPASkills();
		ArrayList<Skills> skillsList = new ArrayList<Skills>();
		try {
			skillsList = skillService.getSkillsList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("username", user);
			request.setAttribute("message", e);
			request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
		}
		request.setAttribute("username", user);
		request.setAttribute("skillsList", skillsList);
		request.setAttribute("idCandidate", idCandidate);
		request.getRequestDispatcher("/skillsFormCreate.jsp").forward(request, response);
	}

}
