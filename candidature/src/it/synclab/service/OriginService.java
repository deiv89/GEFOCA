package it.synclab.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.synclab.business.Origin;
import it.synclab.database.ConnectionFactory;

public class OriginService implements IOriginService {

	private static OriginService instance = new OriginService();

	private OriginService() {

	}

	public static OriginService getInstance() {
		if (instance == null)
			instance = new OriginService();
		return instance;
	}

	public void create(Origin origin, String surname) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "insert into origin (ID_ORIGIN, description, address, phone) "
					+ "values (seq_candidate.NEXTVAL, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, origin.getDescription());
			stmt.setString(2, origin.getAddress());
			stmt.setString(3, origin.getPhone());
			stmt.executeUpdate();
			conn.commit();

			int idOrigin = getLastIdOrigin(conn);
			setIdOriginCandidate(conn, idOrigin, surname);

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	private int getLastIdOrigin(Connection conn) throws SQLException {
		int idOrigin = 0;
		ResultSet rs = null;
		try {
			String sql = "select max (id_origin) from origin";
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idOrigin = rs.getInt(1);
			}
		}catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
		}
		return idOrigin;

	}

	private void setIdOriginCandidate(Connection conn, int idOrigin, String surname) throws SQLException {

		try {
			String sql = "update candidate set id_origin = ? where surname = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idOrigin);
			stmt.setString(2, surname);
			stmt.executeUpdate();
		}  catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		}
	}

	@Override
	public Origin read(int idOrigin) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		ResultSet rs = null;
		Origin origin = null;
		try {
			conn = ConnectionFactory.getInstance();
			String sql = "SELECT id_origin, description, address, phone FROM origin " + "WHERE id_origin = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idOrigin);
			rs = stmt.executeQuery();

			if (rs.next()) {
				origin = new Origin();
				origin.setIdOrigin(rs.getInt(1));
				origin.setDescription(rs.getString(2));
				origin.setAddress(rs.getString(3));
				origin.setPhone(rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		}finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		}
		return origin;
	}

	@Override
	public void update(Origin origin) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "update origin set description = ?, address = ?, phone = ? " + "where id_origin = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, origin.getDescription());
			stmt.setString(2, origin.getAddress());
			stmt.setString(3, origin.getPhone());
			stmt.setInt(4, origin.getIdOrigin());
			stmt.executeUpdate();
			conn.commit();
		}catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void delete(int idOrigin) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from origin where id_origin = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idOrigin);
			stmt.executeUpdate();
			conn.commit();
		}catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("SI E' VERIFICATO UN PROBLEMA DURANTE LA CONNESSIONE AL DB " + e.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public Origin create(Origin origin) throws ClassNotFoundException, SQLException {
		return origin;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIdOriginCandidate(int idCandidate, int idOrigin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


}
