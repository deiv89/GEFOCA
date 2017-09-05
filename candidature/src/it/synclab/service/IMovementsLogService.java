package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.synclab.business.Movement;

public interface IMovementsLogService {

	public Movement create(Movement movement) throws ClassNotFoundException, SQLException;

	public ArrayList<Movement> read();

	//public ArrayList<Candidate> getCandidateList()
		//	throws EmptyCandidateListException, ClassNotFoundException, SQLException;

	//public void update(Candidate candidate) throws SQLException, ClassNotFoundException;

	//public void delete(int idCandidate) throws ClassNotFoundException, SQLException;
	
	//public List<Candidate> getCandidatesByFilter(Candidate candidate);


}
