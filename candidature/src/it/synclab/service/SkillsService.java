package it.synclab.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate_Skills;
import it.synclab.business.Skills;
import it.synclab.database.ConnectionFactory;

public class SkillsService implements ISkillsService {

	private static SkillsService instance = new SkillsService();

	private SkillsService() {
	}

	public static SkillsService getInstance() {
		if (instance == null)
			instance = new SkillsService();
		return instance;
	}

/*	@Override
	public void create(ArrayList<Skills> skillsCandidateList) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "insert into candidate_skills (id_candidate, id_skill, skill_level) values (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (int i = 0; i < skillsCandidateList.size(); i++) {
				stmt.setInt(1, skillsCandidateList.get(i).getIdCandidate());
				stmt.setInt(2, skillsCandidateList.get(i).getIdSkill());
				stmt.setInt(3, skillsCandidateList.get(i).getValuationLevel());
				stmt.executeUpdate();
			}
			conn.commit();

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	}*/

	//@Override
	public ArrayList<Candidate_Skills> read(int idCandidate) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Candidate_Skills> candidateSkills = new ArrayList<Candidate_Skills>();
		Candidate_Skills skills;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_candidate, id_skill, skill_level FROM candidate_skills " + "WHERE id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				skills = new Candidate_Skills();
				skills.setIdCandidate(rs.getInt(1));
				skills.setIdSkill(rs.getInt(2));
				skills.setValuationLevel(rs.getInt(3));
				candidateSkills.add(skills);
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		}
		return candidateSkills;
	}

	public void update(ArrayList<Skills> skillsCandidateList) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "UPDATE candidate_skills set id_skill = ?, skill_level = ? "
					+ "WHERE id_candidate = ? AND id_skill = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (int i = 0; i < skillsCandidateList.size(); i++) {
				stmt.setInt(1, skillsCandidateList.get(i).getIdSkill());
				stmt.setInt(2, skillsCandidateList.get(i).getValuationLevel());
				stmt.setInt(3, skillsCandidateList.get(i).getIdCandidate());
				stmt.setInt(4, skillsCandidateList.get(i).getIdSkill());
				stmt.executeUpdate();
			}
			conn.commit();

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public void delete(int idCandidate) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from candidate_skills where id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			stmt.executeUpdate();
			conn.commit();
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public ArrayList<Skills> getSkillsList() throws ClassNotFoundException, SQLException {
		ArrayList<Skills> skillList = new ArrayList<Skills>();
		Skills skill = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_skill, skill_name, skill_category from skills_matrix";
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				skill = new Skills();
				skill.setIdSkill(rs.getInt(1));
				skill.setParameterName(rs.getString(2));
				//skill.setCategorySkill(rs.getString(3));
				skillList.add(skill);
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		}
		return skillList;
	}

	@Override
	public void deleteSingleSkill(int idCandidate, int idSkill) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from candidate_skills where id_candidate = ? AND id_skill = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			stmt.setInt(2, idSkill);
			stmt.executeUpdate();
			conn.commit();
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public void create(ArrayList<Candidate_Skills> skillsCandidateList) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Candidate_Skills> candidateSkills, int idCandidate)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	

}
