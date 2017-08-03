package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate_Languages;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Language;

public interface IEvaluationFormService {
	
	//public void create(EvaluationForm evaluationForm, ArrayList<Language> spokenLanguages) throws ClassNotFoundException, SQLException;
	public void create(EvaluationForm evaluationForm) throws ClassNotFoundException, SQLException;
	public void persistSpokenLang(ArrayList<Candidate_Languages> spokenLanguages);
	public ArrayList<Candidate_Languages> getSpokenLanguages(int idCandidate);
	public EvaluationForm read(int idCandidate) throws ClassNotFoundException, SQLException;
	//public void update(EvaluationForm evaluationForm, ArrayList<Language> spokenLanguages) throws SQLException, ClassNotFoundException;
	public void delete(int idCandidate) throws ClassNotFoundException, SQLException;
	public ArrayList<Language> getLanguagesList() throws ClassNotFoundException, SQLException;
	public void deleteSingleLanguage(int idCandidate, int idLanguage) throws ClassNotFoundException, SQLException;
	public void deleteCandidateLanguages(int idCandidate);
	public void updateEvalForm(EvaluationForm eform);
	public void updateSpokenLang(ArrayList<Candidate_Languages> spokenLanguages, int idCandidate);
	
}
