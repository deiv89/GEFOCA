package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate_Skills;
import it.synclab.business.Skills;

public class SkillsCollectionService implements ISkillsService {

	private ArrayList<Skills> skillsList = new ArrayList<Skills>();

	public ArrayList<Skills> getSkillsList() {
		Skills skills = new Skills();
		skills.setParameterName("HTML");
		skillsList.add(skills);
		skills = new Skills();
		skills.setParameterName("JAVASCRIPT");
		skillsList.add(skills);
		skills = new Skills();
		skills.setParameterName("JAVA");
		skillsList.add(skills);
		skills = new Skills();
		skills.setParameterName("MYSQL");
		skillsList.add(skills);
		skills = new Skills();
		skills.setParameterName("JUNIT");
		skillsList.add(skills);

		return skillsList;
	}

	private ArrayList<Candidate_Skills> skillsCandidateList = new ArrayList<Candidate_Skills>();

	public ArrayList<Candidate_Skills> getSkillsCandidateList() {
		return skillsCandidateList;
	}

	public void setSkillsCandidateList(ArrayList<Candidate_Skills> skillsCandidateList) {
		this.skillsCandidateList = skillsCandidateList;
	}

	private static SkillsCollectionService instance = new SkillsCollectionService();

	private SkillsCollectionService() {
	}

	public static SkillsCollectionService getInstance() {
		if (instance == null)
			instance = new SkillsCollectionService();
		return instance;
	}

	public void create(Skills skills) {
		skillsList.add(skills);
	}

	@Override
	public ArrayList<Candidate_Skills> read(int idCandidate) {
		ArrayList<Candidate_Skills> skillsCurrentCandidateList = new ArrayList<Candidate_Skills>();
		for (int i = 0; i < skillsCandidateList.size(); i++) {
			if (skillsCandidateList.get(i).getIdCandidate() == idCandidate) {
				skillsCurrentCandidateList.add(skillsCandidateList.get(i));
			}

		}
		return skillsCurrentCandidateList;
	}

	/*@Override
	public void update(Skills skills) {
		int index = 0;
		for (int i = 0; i < skillsCandidateList.size(); i++) {
			if (skillsCandidateList.get(i).getIdCandidate() == skills.getIdCandidate())
				index = i;
			skillsList.set(index, skills);
		}
		
	}*/

	@Override
	public void delete(int idCandidate) {
		for (int i = 0; i < skillsCandidateList.size(); i++) {
			if (skillsCandidateList.get(i).getIdCandidate() == idCandidate)
				skillsCandidateList.remove(i);
		}
	}

	public void updatee(ArrayList<Candidate_Skills> skillsCurrent) {
		int index = 0;
		for (int i = 0; i < skillsCandidateList.size(); i++) {
			for ( int j = 0; j < skillsCurrent.size(); j++){
				if(skillsCandidateList.get(i).getIdCandidate() == skillsCurrent.get(j).getIdCandidate()){
					index = i;
					skillsCandidateList.set(index, skillsCurrent.get(j));
					i++;
				}
				
			}
		}
	}

	@Override
	public void create(ArrayList<Candidate_Skills> skillsCandidateList) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSingleSkill(int idCandidate, int idSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(ArrayList<Skills> skillsCurrent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Candidate_Skills> candidateSkills, int idCandidate)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	

	

}
