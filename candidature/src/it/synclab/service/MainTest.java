package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate;
import it.synclab.business.CandidateFactory;
import it.synclab.business.Candidate_Languages;
import it.synclab.business.Candidate_Skills;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Origin;
import it.synclab.business.Skills;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
import it.synclab.jpa.JPACandidate;
import it.synclab.jpa.JPAEvaluationForm;
import it.synclab.jpa.JPAOrigin;
import it.synclab.jpa.JPASkills;

public class MainTest {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		
		/*JPACandidate service = JPACandidate.getInstance();
		Candidate candidate = null;
		try {
			candidate = service.read(249);
		} catch (EmptyCandidateListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CandidateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("pyppo");

		if (candidate != null && candidate.getSkillRels() != null && candidate.getSkillRels().size() > 0) {

			for (Candidate_Skills skill : candidate.getSkillRels()) {

				System.out.println(skill.getIdSkill() + " - " + skill.getIdCandidate());
			}
		}

		System.out.println("pyppo");

		if (candidate != null && candidate.getSpokenLanguages() != null && candidate.getSpokenLanguages().size() > 0) {

			for (Candidate_Languages candidateLang : candidate.getSpokenLanguages()) {

				System.out.println(candidateLang.getLanguageLevel() + " - " + candidateLang.getIdCandidate());
			}
		}*/

		/*System.out.println("spokenLanguages");

		EvaluationForm evalForm = new EvaluationForm();
		evalForm.setIdCandidate(339);
		evalForm.setInterviewerName("pippo");
		evalForm.setLevelComunication(4);
		evalForm.setLevelPresence(3);
		evalForm.setLevelDynamicity(2);
		evalForm.setExperience("tantissime");
		evalForm.setMotivazioni("plausibili");
		evalForm.setCurrentPay(1250.69);
		evalForm.setRenumeration_required(1600);

		ArrayList<Candidate_Languages> spokenLang = new ArrayList<>();
		Candidate_Languages candidateLang = new Candidate_Languages();
		candidateLang.setIdCandidate(339);
		candidateLang.setIdLanguage(1);
		candidateLang.setLanguageLevel(4);
		spokenLang.add(candidateLang);
		candidateLang = new Candidate_Languages();
		candidateLang.setIdCandidate(339);
		candidateLang.setIdLanguage(2);
		candidateLang.setLanguageLevel(3);
		spokenLang.add(candidateLang);

		JPAEvaluationForm efService = JPAEvaluationForm.getInstance();
		efService.create(evalForm);
		efService.persistSpokenLang(spokenLang);*/
		
		/*System.out.println("SKILLS");
		int idCandidate = 342;
		Candidate_Skills cSkills = new Candidate_Skills();
		ArrayList<Candidate_Skills> skillsList = new ArrayList<Candidate_Skills>();
		cSkills.setIdCandidate(idCandidate);
		cSkills.setIdSkill(1);
		cSkills.setValuationLevel(4);
		skillsList.add(cSkills);
		cSkills = new Candidate_Skills();
		cSkills.setIdCandidate(idCandidate);
		cSkills.setIdSkill(2);
		cSkills.setValuationLevel(3);
		skillsList.add(cSkills);
		
		ISkillsService skillService = JPASkills.getInstance();
		skillService.create(skillsList);
		ArrayList<Skills> candidateSkillsList = skillService.read(idCandidate);
		for(int i=0; i<candidateSkillsList.size(); i++){
			System.out.println(candidateSkillsList.get(i).getIdCandidate());
			System.out.println(candidateSkillsList.get(i).getIdSkill());
			System.out.println(candidateSkillsList.get(i).getValuationLevel());
			System.out.println(" ");
		}*/
		
		/*System.out.println("ORIGIN");
		
		Origin origin = new Origin();
		origin.setDescription("test");
		origin.setAddress("viaaaaa");
		origin.setPhone("444-555-666");
		
		JPAOrigin originService = JPAOrigin.getInstance();
		Origin currentOrigin = originService.create(origin);
		System.out.println(currentOrigin.getIdOrigin());
		System.out.println(currentOrigin.getDescription());
		System.out.println(currentOrigin.getAddress());
		System.out.println(currentOrigin.getPhone());
*/
		/*System.out.println("skillLevels");
		
		int idCandidate = 267;
		JPASkills skillService = JPASkills.getInstance();
		ArrayList<Candidate_Skills> currentSkills = skillService.read(idCandidate);
		
		if (currentSkills != null && currentSkills.size() > 0){
			for(Candidate_Skills skill : currentSkills){
				System.out.println(skill.getIdCandidate() +  " - " + skill.getIdSkill() + " - " + skill.getValuationLevel());
			}
		}*/
		
		/*System.out.println("pl/sql");
		int idCandidate = 273;
		Candidate candidate = new Candidate();
		CandidateService candidateService = CandidateService.getInstance();
		candidate = candidateService.getCandidateByPLSQL(idCandidate);
		System.out.println("Nome" + candidate.getName());
		System.out.println("Cognome" + candidate.getSurname());
		System.out.println("Data di Nascita" + candidate.getDateOfBirth());
		System.out.println("Qualificazione" + candidate.getQualification());
		System.out.println("Id Candidato" + candidate.getIdCandidate());
		System.out.println("ID Origine" + candidate.getIdOrigin());*/
		
		try {

			//CandidateService candidateService = CandidateService.getInstance();
			int idCandidate = 272;
			Candidate candidate = new Candidate();
			candidate = CandidateService.callOracleStoredProcCURSORParameter(idCandidate);
			System.out.println("Nome " + candidate.getName());
			System.out.println("Cognome " + candidate.getSurname());
			System.out.println("Data di Nascita " + candidate.getDateOfBirth());
			System.out.println("Qualificazione " + candidate.getQualification());
			System.out.println("Id Candidato " + candidate.getIdCandidate());
			System.out.println("ID Origine " + candidate.getIdOrigin());

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	
	
		System.out.println("DONE");
		
	}
}
