package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.synclab.business.Candidate;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;

public interface ICandidateService {

	public void create(Candidate candidate) throws ClassNotFoundException, SQLException;

	public Candidate read(int idCandidate)
			throws EmptyCandidateListException, CandidateNotFoundException, ClassNotFoundException, SQLException;

	public ArrayList<Candidate> getCandidateList()
			throws EmptyCandidateListException, ClassNotFoundException, SQLException;

	public void update(Candidate candidate) throws SQLException, ClassNotFoundException;

	public void delete(int idCandidate) throws ClassNotFoundException, SQLException;
	
	public List<Candidate> getCandidatesByFilter(Candidate candidate);


}
