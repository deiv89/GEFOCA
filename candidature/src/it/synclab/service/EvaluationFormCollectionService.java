package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate_Languages;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Language;

public class EvaluationFormCollectionService implements IEvaluationFormService {

	private ArrayList<EvaluationForm> evaluationFormList = new ArrayList<EvaluationForm>();

	public ArrayList<EvaluationForm> getEvaluationFormList() {

		return evaluationFormList;

	}

	private static EvaluationFormCollectionService instance = new EvaluationFormCollectionService();

	private EvaluationFormCollectionService() {

	}

	public static EvaluationFormCollectionService getInstance() {
		if (instance == null)
			instance = new EvaluationFormCollectionService();
		return instance;
	}

	
	public void create(EvaluationForm evaluationForm) {
		evaluationFormList.add(evaluationForm);
	}

	@Override
	public EvaluationForm read(int idCandidate) {
		EvaluationForm evaluationForm = new EvaluationForm();
		for (int i = 0; i < evaluationFormList.size(); i++) {
			if (evaluationFormList.get(i).getIdCandidate() == idCandidate) {
				evaluationForm.setExperience(evaluationFormList.get(i).getExperience());
				evaluationForm.setIdCandidate(idCandidate);
				evaluationForm.setInterviewerName(evaluationFormList.get(i).getInterviewerName());
				evaluationForm.setLevelComunication(evaluationFormList.get(i).getLevelComunication());
				evaluationForm.setLevelDynamicity(evaluationFormList.get(i).getLevelDynamicity());
				evaluationForm.setLevelPresence(evaluationFormList.get(i).getLevelPresence());
				evaluationForm.setMotivazioni(evaluationFormList.get(i).getMotivazioni());
				evaluationForm.setSpokenLanguages(evaluationFormList.get(i).getSpokenLanguages());
				evaluationForm.setTransfer(evaluationFormList.get(i).getTransfer());
				evaluationForm.setCurrentPay(evaluationFormList.get(i).getCurrentPay());
				evaluationForm.setRenumeration_required(evaluationFormList.get(i).getRenumeration_required());
			}
		}
		return evaluationForm;
	}

	
	public void update(EvaluationForm evaluationForm) {
		int index = 0;
		for (int i = 0; i < evaluationFormList.size(); i++) {
			if (evaluationFormList.get(i).getIdCandidate() == evaluationForm.getIdCandidate())
				index = i;
		}
		evaluationFormList.set(index, evaluationForm);
	}

	@Override
	public void delete(int idCandidate) {
		for(int i = 0; i < evaluationFormList.size(); i++){
			if(evaluationFormList.get(i).getIdCandidate() == idCandidate)
				evaluationFormList.remove(i);
		}
	}

	public void create(EvaluationForm evaluationForm, ArrayList<Language> spokenLanguages)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(EvaluationForm evaluationForm, ArrayList<Language> spokenLanguages)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Language> getLanguagesList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateSingleLanguage(EvaluationForm evaluationForm, int idLanguage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSingleLanguage(int idCandidate, int id_language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistSpokenLang(ArrayList<Candidate_Languages> spokenLanguages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Candidate_Languages> getSpokenLanguages(int idCandidate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEvalForm(EvaluationForm eform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSpokenLang(ArrayList<Candidate_Languages> spokenLanguages, int idCandidate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCandidateLanguages(int idCandidate) {
		// TODO Auto-generated method stub
		
	}
	
	

}
