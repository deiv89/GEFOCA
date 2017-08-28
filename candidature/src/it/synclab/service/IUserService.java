package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.synclab.business.User;

public interface IUserService {

	public void create(User user) throws ClassNotFoundException, SQLException;

	public ArrayList<User> read(String userName);

	//public ArrayList<Candidate> getCandidateList()
		//	throws EmptyCandidateListException, ClassNotFoundException, SQLException;

	//public void update(Candidate candidate) throws SQLException, ClassNotFoundException;

	//public void delete(int idCandidate) throws ClassNotFoundException, SQLException;
	
	//public List<Candidate> getCandidatesByFilter(Candidate candidate);


}
