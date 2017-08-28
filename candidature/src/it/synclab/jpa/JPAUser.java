package it.synclab.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.*;

import it.synclab.business.User;
import it.synclab.database.EntityManagerUtil;
import it.synclab.service.IUserService;

public class JPAUser implements IUserService {

	private static JPAUser instance = new JPAUser();

	public static JPAUser getInstance() {
		if (instance == null)
			instance = new JPAUser();
		return instance;
	}

	private JPAUser() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> read(String userName) {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			entityManager.getTransaction().begin();
			userList = (ArrayList<User>) entityManager.createQuery("FROM User WHERE userName = :username").setParameter("username", userName).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		if (userList == null || userList.isEmpty()) {
			return userList;
		}
		return userList;
	}

	@Override
	public void create(User user) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * @Override public ArrayList<Candidate> getCandidateList() throws
	 * EmptyCandidateListException, ClassNotFoundException, SQLException {
	 * ArrayList<Candidate> currentCandidates = new ArrayList<Candidate>(); try
	 * { entityManager.getTransaction().begin();
	 * 
	 * @SuppressWarnings("unchecked") ArrayList<Candidate> candidateList =
	 * (ArrayList<Candidate>) entityManager.createQuery("from Candidate")
	 * .getResultList(); currentCandidates = candidateList;
	 * entityManager.getTransaction().commit();
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * entityManager.getTransaction().rollback(); } return currentCandidates; }
	 * 
	 * @Override public void update(Candidate candidate) throws SQLException,
	 * ClassNotFoundException { try { entityManager.getTransaction().begin();
	 * Candidate currentCandidate = entityManager.find(Candidate.class,
	 * candidate.getIdCandidate());
	 * currentCandidate.setIdOrigin(candidate.getIdOrigin());
	 * currentCandidate.setIdCandidate(candidate.getIdCandidate());
	 * currentCandidate.setSurname(candidate.getSurname());
	 * currentCandidate.setName(candidate.getName());
	 * currentCandidate.setDateOfBirth(candidate.getDateOfBirth());
	 * currentCandidate.setQualification(candidate.getQualification());
	 * entityManager.getTransaction().commit(); } catch (Exception e) {
	 * e.printStackTrace(); entityManager.getTransaction().rollback(); }
	 * 
	 * }
	 * 
	 * @Override public void delete(int idCandidate) throws
	 * ClassNotFoundException, SQLException { try {
	 * entityManager.getTransaction().begin(); Candidate candidate =
	 * entityManager.find(Candidate.class, idCandidate);
	 * entityManager.remove(candidate); entityManager.getTransaction().commit();
	 * } catch (Exception e) { e.printStackTrace();
	 * entityManager.getTransaction().rollback(); }
	 * 
	 * }
	 * 
	 * public Candidate retrieveCandidateSkill(int idCandidate) throws
	 * ClassNotFoundException, SQLException {
	 * 
	 * Candidate candidate = new Candidate(); try {
	 * entityManager.getTransaction().begin();
	 * 
	 * @SuppressWarnings("unchecked") ArrayList<Candidate_Skills>
	 * skillsCandidates = (ArrayList<Candidate_Skills>) entityManager
	 * .createQuery("from Candidate_Skills").getResultList();
	 * 
	 * candidate.setSkills(skillsCandidates);
	 * 
	 * for (int i=0; i<skillsCandidates.size(); i++){ Candidate_Skills cSkills =
	 * new Candidate_Skills(); if(skillsCandidates.get(i).getIdCandidate() ==
	 * idCandidate){ cSkills.setIdCandidate(idCandidate);
	 * cSkills.setIdSkill(skillsCandidates.get(i).getIdSkill());
	 * cSkills.setValuationLevel(skillsCandidates.get(i). getValuationLevel());
	 * skillsCurrentCandidate.add(cSkills); } }
	 * 
	 * // skillsCurrentCandidate = // entityManager.find(Candidate_Skills.class,
	 * idCandidate); entityManager.getTransaction().commit(); } catch (Exception
	 * e) { e.printStackTrace(); entityManager.getTransaction().rollback(); }
	 * return candidate; }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public ArrayList<Candidate> getCandidatesByFilter(Candidate
	 * candidate) {
	 * 
	 * Query query = null; try { entityManager.getTransaction().begin(); query =
	 * entityManager
	 * .createQuery("SELECT c FROM Candidate c WHERE (:name is null OR name LIKE :name) AND "
	 * + "(:surname is null OR surname LIKE :surname) ORDER BY name ASC")
	 * .setParameter("name", candidate.getName() + "%") .setParameter("surname",
	 * candidate.getSurname() + "%"); entityManager.getTransaction().commit(); }
	 * catch (Exception e) { e.printStackTrace();
	 * entityManager.getTransaction().rollback(); }
	 * 
	 * return (ArrayList<Candidate>) query.getResultList(); }
	 */

}
