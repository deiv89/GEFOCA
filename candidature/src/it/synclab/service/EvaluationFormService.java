package it.synclab.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Candidate_Languages;
import it.synclab.business.EvaluationForm;
import it.synclab.business.Language;
import it.synclab.database.ConnectionFactory;

public class EvaluationFormService implements IEvaluationFormService {

	private static EvaluationFormService instance = new EvaluationFormService();

	private EvaluationFormService() {

	}

	public static EvaluationFormService getInstance() {
		if (instance == null)
			instance = new EvaluationFormService();
		return instance;
	}

	//@Override
	public void create(EvaluationForm evaluationForm, ArrayList<Language> spokenLanguages)
			throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "insert into evaluation_form (id_candidate, interviewer_name, presence_level, "
					+ "comunication_level, dynamicity_level, experiences, motivation, "
					+ "transfer, current_pay, remuneration_required) " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, evaluationForm.getIdCandidate());
			stmt.setString(2, evaluationForm.getInterviewerName());
			stmt.setInt(3, evaluationForm.getLevelPresence());
			stmt.setInt(4, evaluationForm.getLevelComunication());
			stmt.setInt(5, evaluationForm.getLevelDynamicity());
			stmt.setString(6, evaluationForm.getExperience());
			stmt.setString(7, evaluationForm.getMotivazioni());
			stmt.setString(8, evaluationForm.getTransfer());
			stmt.setDouble(9, evaluationForm.getCurrentPay());
			stmt.setDouble(10, evaluationForm.getRenumeration_required());

			stmt.executeUpdate();
			conn.commit();

			insertSpokenLanguages(conn, spokenLanguages);

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

	private void insertSpokenLanguages(Connection conn, ArrayList<Language> spokenLanguages) throws SQLException {
		try {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO candidate_languages (id_candidate, id_language, language_level) "
					+ "VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (int i = 0; i < spokenLanguages.size(); i++) {
				stmt.setInt(1, spokenLanguages.get(i).getIdCandidate());
				stmt.setInt(2, spokenLanguages.get(i).getIdLanguage());
				stmt.setInt(3, spokenLanguages.get(i).getLanguageLevel());
				stmt.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		}
	}

	@Override
	public EvaluationForm read(int idCandidate) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		ResultSet rs = null;
		EvaluationForm evaluationForm = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_candidate, interviewer_name, presence_level, comunication_level, "
					+ "dynamicity_level, experiences, motivation, transfer, current_pay, "
					+ "remuneration_required FROM evaluation_form " + "WHERE id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			rs = stmt.executeQuery();
			if (rs.next()) {
				evaluationForm = new EvaluationForm();
				evaluationForm.setIdCandidate(rs.getInt(1));
				evaluationForm.setInterviewerName(rs.getString(2));
				evaluationForm.setLevelPresence(rs.getInt(3));
				evaluationForm.setLevelComunication(rs.getInt(4));
				evaluationForm.setLevelDynamicity(rs.getInt(5));
				evaluationForm.setExperience(rs.getString(6));
				evaluationForm.setMotivazioni(rs.getString(7));
				evaluationForm.setTransfer(rs.getString(8));
				evaluationForm.setCurrentPay(rs.getDouble(9));
				evaluationForm.setRenumeration_required(rs.getDouble(10));
			}

			//evaluationForm.setSpokenLanguages(getSpokenLanguages(conn, evaluationForm));

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
		return evaluationForm;
	}

	@SuppressWarnings("unused")
	private ArrayList<Language> getSpokenLanguages(Connection conn, EvaluationForm evaluationForm)
			throws ClassNotFoundException, SQLException {
		ArrayList<Language> spokenLanguages = new ArrayList<Language>();
		Language lang = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT candidate_languages.id_candidate, candidate_languages.id_language, "
					+ "candidate_languages.language_level, languages.language_name "
					+ "FROM candidate_languages INNER JOIN languages "
					+ "ON candidate_languages.ID_LANGUAGE = languages.ID_LANGUAGE " + "WHERE id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, evaluationForm.getIdCandidate());
			rs = stmt.executeQuery();
			while (rs.next()) {
				lang = new Language();
				lang.setIdCandidate(rs.getInt(1));
				lang.setIdLanguage(rs.getInt(2));
				lang.setLanguageLevel(rs.getInt(3));
				lang.setLanguageName(rs.getString(4));
				spokenLanguages.add(lang);
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
		return spokenLanguages;
	}

	public void update(EvaluationForm evaluationForm, ArrayList<Language> spokenLanguages)
			throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "update evaluation_form SET interviewer_name = ?, presence_level = ?, "
					+ "COMUNICATION_LEVEL = ?, DYNAMICITY_LEVEL = ?, EXPERIENCES = ?, " + "MOTIVATION = ?, "
					+ "TRANSFER = ?, CURRENT_PAY = ?, REMUNERATION_REQUIRED = ? " + "WHERE id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, evaluationForm.getInterviewerName());
			stmt.setInt(2, evaluationForm.getLevelPresence());
			stmt.setInt(3, evaluationForm.getLevelComunication());
			stmt.setInt(4, evaluationForm.getLevelDynamicity());
			stmt.setString(5, evaluationForm.getExperience());
			stmt.setString(6, evaluationForm.getMotivazioni());
			stmt.setString(7, evaluationForm.getTransfer());
			stmt.setDouble(8, evaluationForm.getCurrentPay());
			stmt.setDouble(9, evaluationForm.getRenumeration_required());
			stmt.setInt(10, evaluationForm.getIdCandidate());
			stmt.executeUpdate();
			conn.commit();

			updateSpokenLanguages(conn, spokenLanguages);
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

	private void updateSpokenLanguages(Connection conn, ArrayList<Language> spokenLanguages)
			throws ClassNotFoundException, SQLException {

		try {
			conn.setAutoCommit(false);
			String sql = "UPDATE candidate_languages SET id_language = ?, language_level = ? "
					+ "WHERE id_candidate = ? AND id_language = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (int i = 0; i < spokenLanguages.size(); i++) {
				stmt.setInt(1, spokenLanguages.get(i).getIdLanguage());
				stmt.setInt(2, spokenLanguages.get(i).getLanguageLevel());
				stmt.setInt(3, spokenLanguages.get(i).getIdCandidate());
				stmt.setInt(4, spokenLanguages.get(i).getIdLanguage());
				stmt.executeUpdate();
			}
			conn.commit();
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
			String sql = "delete from evaluation_form where id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			stmt.executeUpdate();
			deleteSpokenLanguages(conn, idCandidate);
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

	private void deleteSpokenLanguages(Connection conn, int idCandidate) throws ClassNotFoundException, SQLException {

		try {
			conn.setAutoCommit(false);
			String sql = "delete from candidate_languages where id_candidate = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} 
	}

	@Override
	public ArrayList<Language> getLanguagesList() throws ClassNotFoundException, SQLException {
		ArrayList<Language> languagesList = new ArrayList<Language>();
		Language lang = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_language, language_name FROM languages";
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				lang = new Language();
				lang.setIdLanguage(rs.getInt(1));
				lang.setLanguageName(rs.getString(2));
				languagesList.add(lang);
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
		return languagesList;
	}

	@Override
	public void deleteSingleLanguage(int idCandidate, int idLanguage) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from candidate_languages where id_candidate = ? AND id_language = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCandidate);
			stmt.setInt(2, idLanguage);
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
	public void create(EvaluationForm evaluationForm) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistSpokenLang(ArrayList<Candidate_Languages> spokenLanguages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Candidate_Languages> getSpokenLanguages(int idCandidate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEvalForm(EvaluationForm eform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSpokenLang(ArrayList<Candidate_Languages> spokenLanguages, int idCandidate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCandidateLanguages(int idCandidate) {
		// TODO Auto-generated method stub
		
	}

}
