package it.synclab.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import it.synclab.business.Candidate_Skills;
import it.synclab.business.Skills;
import it.synclab.database.EntityManagerUtil;
import it.synclab.service.ISkillsService;

public class JPASkills implements ISkillsService {

	private static JPASkills instance = new JPASkills();

	public static JPASkills getInstance() {
		if (instance == null)
			instance = new JPASkills();
		return instance;
	}

	private JPASkills() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@Override
	public void create(ArrayList<Candidate_Skills> skillsCandidateList) throws ClassNotFoundException, SQLException {

		try {
			//entityManager.getTransaction().begin();
			
			/*for (Skills skill : skillsCandidateList){
				entityManager.persist(skill);
				entityManager.getTransaction().commit();
			}*/
			entityManager.getTransaction().begin();
			
			for(Candidate_Skills cSkill : skillsCandidateList){
				entityManager.persist(cSkill);
			}
			
			/*for (int i=0; i < skillsCandidateList.size(); i++){
				Candidate_Skills skill = new Candidate_Skills();
				skill.setIdSkill(skillsCandidateList.get(i).getIdSkill());
				skill.setIdCandidate(skillsCandidateList.get(i).getIdCandidate());
				skill.setValuationLevel(skillsCandidateList.get(i).getValuationLevel());
				entityManager.persist(skill);
			}*/
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public ArrayList<Candidate_Skills> read(int idCandidate) throws ClassNotFoundException, SQLException {

		ArrayList<Candidate_Skills> skillsCurrentCandidate = new ArrayList<Candidate_Skills>();
		try {
			entityManager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			ArrayList<Candidate_Skills> skillsCandidates = (ArrayList<Candidate_Skills>) entityManager.createQuery("from Candidate_Skills WHERE id_candidate = :idCandidate").setParameter("idCandidate", idCandidate).getResultList();
			
			for (int i=0; i<skillsCandidates.size(); i++){
				Candidate_Skills cSkills = new Candidate_Skills();
				if(skillsCandidates.get(i).getIdCandidate() == idCandidate){
					cSkills.setIdCandidate(idCandidate);
					cSkills.setIdSkill(skillsCandidates.get(i).getIdSkill());
					cSkills.setValuationLevel(skillsCandidates.get(i).getValuationLevel());
					skillsCurrentCandidate.add(cSkills);
				}
			}
			//skillsCurrentCandidate = entityManager.find(Candidate_Skills.class, idCandidate);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return skillsCurrentCandidate;
	}


	@Override
	public void delete(int idCandidate) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			ArrayList<Candidate_Skills> skillsCandidates = (ArrayList<Candidate_Skills>) entityManager.createQuery("from Candidate_Skills WHERE id_candidate = :idCandidate").setParameter("idCandidate", idCandidate).getResultList();
			
			for(Candidate_Skills cSkill: skillsCandidates){
				entityManager.remove(cSkill);
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public ArrayList<Skills> getSkillsList() throws ClassNotFoundException, SQLException {
		ArrayList<Skills> skillsList = new ArrayList<Skills>();
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			ArrayList<Skills> tempList = (ArrayList<Skills>) entityManager.createQuery("from Skills")
					.getResultList();
			skillsList = tempList;
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return skillsList;
	}

	@Override
	public void deleteSingleSkill(int idCandidate, int idSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ArrayList<Candidate_Skills> candidateSkills, int idCandidate)
			throws ClassNotFoundException, SQLException {
		try{
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			ArrayList<Candidate_Skills> currentCandidateSkills = (ArrayList<Candidate_Skills>) entityManager.createQuery("from Candidate_Skills WHERE id_candidate = :idCandidate").setParameter("idCandidate", idCandidate).getResultList();
			int j = 0;
			for (int i=0; i<currentCandidateSkills.size(); i++){
					currentCandidateSkills.get(i).setIdCandidate(idCandidate);
					currentCandidateSkills.get(i).setIdSkill(candidateSkills.get(j).getIdSkill());
					currentCandidateSkills.get(i).setValuationLevel(candidateSkills.get(j).getValuationLevel());
					j++;
				}
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	

}
