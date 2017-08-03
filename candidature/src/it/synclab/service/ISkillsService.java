package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate_Skills;
import it.synclab.business.Skills;

public interface ISkillsService {

	public void create(ArrayList<Candidate_Skills> skillsCandidateList) throws ClassNotFoundException, SQLException;

	public ArrayList<Candidate_Skills> read(int idCandidate) throws ClassNotFoundException, SQLException;

	public void update(ArrayList<Candidate_Skills> candidateSkills, int idCandidate) throws ClassNotFoundException, SQLException;

	public void delete(int idCandidate) throws ClassNotFoundException, SQLException;
	
	public ArrayList<Skills> getSkillsList() throws ClassNotFoundException, SQLException;
	
	public void deleteSingleSkill(int idCandidate, int idSkill) throws ClassNotFoundException, SQLException;

}
