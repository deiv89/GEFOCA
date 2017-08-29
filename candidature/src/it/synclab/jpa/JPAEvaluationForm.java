package it.synclab.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.*;

import it.synclab.business.Candidate_Languages;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Language;
import it.synclab.database.EntityManagerUtil;
import it.synclab.service.IEvaluationFormService;

public class JPAEvaluationForm implements IEvaluationFormService {

	private static JPAEvaluationForm instance = new JPAEvaluationForm();

	public static JPAEvaluationForm getInstance() {
		if (instance == null)
			instance = new JPAEvaluationForm();
		return instance;
	}

	private JPAEvaluationForm() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@Override
	public void create(EvaluationForm evaluationForm)
			throws ClassNotFoundException, SQLException {

		try {
			 entityManager.getTransaction().begin();
			 entityManager.persist(evaluationForm);
			 entityManager.getTransaction().commit();
			 
		}catch (Exception e) {
			e.printStackTrace();
		    entityManager.getTransaction().rollback();
		    }
	}

	@Override
	public void persistSpokenLang(ArrayList<Candidate_Languages> spokenLanguages) {
		try{
			 entityManager.getTransaction().begin();
			for (Candidate_Languages lang : spokenLanguages){
				 entityManager.persist(lang);
				 //entityManager.getTransaction().commit();
			 }
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		    entityManager.getTransaction().rollback();
		    }
		
	}

	@Override
	public EvaluationForm read(int idCandidate) throws ClassNotFoundException, SQLException {
		
		EvaluationForm evalForm = new EvaluationForm();
		try{
			entityManager.getTransaction().begin();
			evalForm = entityManager.find(EvaluationForm.class, idCandidate);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		      entityManager.getTransaction().rollback();
		    }
		return evalForm;
	}


	@Override
	public void delete(int idCandidate) throws ClassNotFoundException, SQLException {
		try{
			entityManager.getTransaction().begin();
			EvaluationForm evalForm = entityManager.find(EvaluationForm.class, idCandidate);
			entityManager.remove(evalForm);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		      entityManager.getTransaction().rollback();
		    }
		
	}

	@Override
	public ArrayList<Language> getLanguagesList() throws ClassNotFoundException, SQLException {
		ArrayList<Language> currentLanguagesList = new ArrayList<Language>();
		try{
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			ArrayList<Language> languagesList = (ArrayList<Language>) entityManager.createQuery("from Language")
					.getResultList();
			currentLanguagesList = languagesList;
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		      entityManager.getTransaction().rollback();
		    }
		return currentLanguagesList;
	}

	@Override
	public void deleteSingleLanguage(int idCandidate, int idLanguage) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Candidate_Languages> getSpokenLanguages(int idCandidate) {
		ArrayList<Candidate_Languages> candidateSpokenLang = new ArrayList<Candidate_Languages>();
		try {
			entityManager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			ArrayList<Candidate_Languages> candidateLanguages = (ArrayList<Candidate_Languages>) entityManager.createQuery("from Candidate_Languages WHERE id_candidate = :idCandidate").setParameter("idCandidate", idCandidate).getResultList();
			
			for (int i=0; i<candidateLanguages.size(); i++){
				Candidate_Languages cLang = new Candidate_Languages();
				if(candidateLanguages.get(i).getIdCandidate() == idCandidate){
					cLang.setIdCandidate(idCandidate);
					cLang.setIdLanguage(candidateLanguages.get(i).getIdLanguage());
					cLang.setLanguageLevel(candidateLanguages.get(i).getLanguageLevel());
					candidateSpokenLang.add(cLang);
				}
			}
			//skillsCurrentCandidate = entityManager.find(Candidate_Skills.class, idCandidate);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return candidateSpokenLang;
	}

	@Override
	public void updateEvalForm(EvaluationForm eform) {
		try {
			entityManager.getTransaction().begin();
			EvaluationForm currentEvalForm = entityManager.find(EvaluationForm.class, eform.getIdCandidate());
			currentEvalForm.setInterviewerName(eform.getInterviewerName());
			currentEvalForm.setIdCandidate(eform.getIdCandidate());
			currentEvalForm.setLevelComunication(eform.getLevelComunication());
			currentEvalForm.setLevelPresence(eform.getLevelPresence());
			currentEvalForm.setLevelDynamicity(eform.getLevelDynamicity());
			currentEvalForm.setMotivazioni(eform.getMotivazioni());
			currentEvalForm.setCurrentPay(eform.getCurrentPay());
			currentEvalForm.setRenumeration_required(eform.getRenumeration_required());
			currentEvalForm.setExperience(eform.getExperience());
			currentEvalForm.setTransfer(eform.getTransfer());
			currentEvalForm.setAvailability(eform.getAvailability());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateSpokenLang(ArrayList<Candidate_Languages> spokenLanguages, int idCandidate) {
		try{
			entityManager.getTransaction().begin();
			ArrayList<Candidate_Languages> candidateLanguages = (ArrayList<Candidate_Languages>) entityManager.createQuery("from Candidate_Languages WHERE id_candidate = :idCandidate").setParameter("idCandidate", idCandidate).getResultList();
			int j = 0;
			for (int i=0; i<candidateLanguages.size(); i++){
					candidateLanguages.get(i).setIdCandidate(idCandidate);
					candidateLanguages.get(i).setIdLanguage(spokenLanguages.get(j).getIdLanguage());
					candidateLanguages.get(i).setLanguageLevel(spokenLanguages.get(j).getLanguageLevel());
					j++;
				}
			
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteCandidateLanguages(int idCandidate) {
		try {
			entityManager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			ArrayList<Candidate_Languages> candidateLanguages = (ArrayList<Candidate_Languages>) entityManager.createQuery("from Candidate_Languages WHERE id_candidate = :idCandidate").setParameter("idCandidate", idCandidate).getResultList();
			
			for(Candidate_Languages cLang: candidateLanguages){
				entityManager.remove(cLang);
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	
	
}