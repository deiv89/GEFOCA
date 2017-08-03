package it.synclab.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import it.synclab.business.Candidate;
import it.synclab.database.ConnectionFactory;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
import oracle.jdbc.OracleTypes;

//db
public class CandidateService implements ICandidateService {

	private static CandidateService instance = new CandidateService();

	private CandidateService() {
	}

	public static CandidateService getInstance() {
		if (instance == null)
			instance = new CandidateService();
		return instance;
	}

	public void create(Candidate candidate) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "insert into candidate (id_candidate, surname, name, date_of_birth, qualification) "
					+ "values (seq_candidate.NEXTVAL, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, candidate.getSurname());
			stmt.setString(2, candidate.getName());
			stmt.setString(3, candidate.getDateOfBirth());
			stmt.setString(4, candidate.getQualification());
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

	public Candidate read(String candidateSurname) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		ResultSet rs = null;
		Candidate candidate = new Candidate();
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_candidate, surname, name, date_of_birth, qualification, id_origin "
					+ "FROM candidate WHERE surname = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, candidateSurname);
			rs = stmt.executeQuery();

			if (rs.next()) {
				candidate = new Candidate();
				candidate.setIdCandidate(rs.getInt(1));
				candidate.setSurname(rs.getString(2));
				candidate.setName(rs.getString(3));
				candidate.setDateOfBirth(rs.getString(4));
				candidate.setQualification(rs.getString(5));
				candidate.setIdOrigin(rs.getInt(6));
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
		return candidate;
	}

	public Candidate getCandidateByPLSQL(int idCandidate) throws ClassNotFoundException, SQLException {
		Candidate candidate = new Candidate();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "{call Get_candidate(?,?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, idCandidate);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(2);
			// Process all returned result sets
			while (rs.next()) {
				// process result set
				candidate.setIdCandidate(rs.getInt("ID_CANDIDATE"));
				candidate.setIdOrigin(rs.getInt("ID_ORIGIN"));
				candidate.setSurname(rs.getString("SURNAME"));
				candidate.setName(rs.getString("NAME"));
				candidate.setDateOfBirth(rs.getString("DATE_OF_BIRTH"));
				candidate.setQualification(rs.getString("QUALIFICATION"));

			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (cstmt != null)
				cstmt.close();
			if (conn != null)
				conn.close();
		}

		return candidate;
	}
	
	public static Candidate callOracleStoredProcCURSORParameter(int idCandidate) throws SQLException, ClassNotFoundException {

		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Candidate candidate = new Candidate();

		String getDBUSERCursorSql = "{call getDBUSERCursor(?,?)}";

		try {
			dbConnection = ConnectionFactory.getInstance();
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

			callableStatement.setInt(1, idCandidate);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			// execute getDBUSERCursor store procedure
			callableStatement.executeUpdate();

			// get cursor and cast it to ResultSet
			rs = (ResultSet) callableStatement.getObject(2);

			while (rs.next()) {
				candidate.setIdCandidate(rs.getInt("ID_CANDIDATE"));
				candidate.setIdOrigin(rs.getInt("ID_ORIGIN"));
				candidate.setSurname(rs.getString("SURNAME"));
				candidate.setName(rs.getString("NAME"));
				candidate.setDateOfBirth(rs.getString("DATE_OF_BIRTH"));
				candidate.setQualification(rs.getString("QUALIFICATION"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return candidate;
	}

	public ArrayList<Candidate> getCandidateList() throws ClassNotFoundException, SQLException {
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_candidate, surname, name, date_of_birth, qualification, id_origin "
					+ "FROM candidate order by surname ASC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			Candidate candidate;
			while (rs.next()) {
				candidate = new Candidate();
				candidate.setIdCandidate(rs.getInt(1));
				candidate.setSurname(rs.getString(2));
				candidate.setName(rs.getString(3));
				candidate.setDateOfBirth(rs.getString(4));
				candidate.setQualification(rs.getString(5));
				candidate.setIdOrigin(rs.getInt(6));
				candidateList.add(candidate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return candidateList;
	}

	public void update(String candidateSurname, Candidate candidate) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "update candidate set surname = ?, name = ?, date_of_birth = ?, qualification = ? "
					+ "where surname = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, candidate.getSurname());
			stmt.setString(2, candidate.getName());
			stmt.setString(3, candidate.getDateOfBirth());
			stmt.setString(4, candidate.getQualification());
			stmt.setString(5, candidateSurname);
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

	public void delete(String candidateSurname) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from candidate where surname = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, candidateSurname);
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
	public Candidate read(int idCandidate)
			throws EmptyCandidateListException, CandidateNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Candidate candidate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int idCandidate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	

}
