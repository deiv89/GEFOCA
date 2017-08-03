package it.synclab.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.*;

import it.synclab.business.Candidate;
import it.synclab.business.Candidate_Skills;
import it.synclab.database.EntityManagerUtil;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
import it.synclab.service.ICandidateService;

public class JPACandidate implements ICandidateService {

	private static JPACandidate instance = new JPACandidate();

	public static JPACandidate getInstance() {
		if (instance == null)
			instance = new JPACandidate();
		return instance;
	}

	private JPACandidate() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();


	@Override
	public void create(Candidate candidate) throws ClassNotFoundException, SQLException {
		try {
			 entityManager.getTransaction().begin();
			 entityManager.persist(candidate);
			 entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		    entityManager.getTransaction().rollback();
		    }
	}

	@Override
	public Candidate read(int idCandidate)
			throws EmptyCandidateListException, CandidateNotFoundException, ClassNotFoundException, SQLException {
		Candidate candidate = new Candidate();
		try {
			entityManager.getTransaction().begin();
			candidate = entityManager.find(Candidate.class, idCandidate);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		    entityManager.getTransaction().rollback();
		    }
		return candidate;
	}

	@Override
	public ArrayList<Candidate> getCandidateList()
			throws EmptyCandidateListException, ClassNotFoundException, SQLException {
		ArrayList<Candidate> currentCandidates = new ArrayList<Candidate>();
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			ArrayList<Candidate> candidateList = (ArrayList<Candidate>) entityManager.createQuery("from Candidate")
					.getResultList();
			currentCandidates = candidateList;
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return currentCandidates;
	}

	@Override
	public void update(Candidate candidate) throws SQLException, ClassNotFoundException {
		try {
			entityManager.getTransaction().begin();
			Candidate currentCandidate = entityManager.find(Candidate.class, candidate.getIdCandidate());
			currentCandidate.setIdOrigin(candidate.getIdOrigin());
			currentCandidate.setIdCandidate(candidate.getIdCandidate());
			currentCandidate.setSurname(candidate.getSurname());
			currentCandidate.setName(candidate.getName());
			currentCandidate.setDateOfBirth(candidate.getDateOfBirth());
			currentCandidate.setQualification(candidate.getQualification());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	@Override
	public void delete(int idCandidate) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			Candidate candidate = entityManager.find(Candidate.class, idCandidate);
			entityManager.remove(candidate);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		    entityManager.getTransaction().rollback();
		    }
		
	}
	
	public Candidate retrieveCandidateSkill(int idCandidate) throws ClassNotFoundException, SQLException {

		Candidate candidate = new Candidate();
		try {
			entityManager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			ArrayList<Candidate_Skills> skillsCandidates = (ArrayList<Candidate_Skills>) entityManager.createQuery("from Candidate_Skills")
					.getResultList();
			
			candidate.setSkills(skillsCandidates);
			/*for (int i=0; i<skillsCandidates.size(); i++){
				Candidate_Skills cSkills = new Candidate_Skills();
				if(skillsCandidates.get(i).getIdCandidate() == idCandidate){
					cSkills.setIdCandidate(idCandidate);
					cSkills.setIdSkill(skillsCandidates.get(i).getIdSkill());
					cSkills.setValuationLevel(skillsCandidates.get(i).getValuationLevel());
					skillsCurrentCandidate.add(cSkills);
				}
			}*/
			//skillsCurrentCandidate = entityManager.find(Candidate_Skills.class, idCandidate);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return candidate;
	}

}
