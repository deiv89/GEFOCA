package it.synclab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// Database credentials
	static final String USER = "cepics";
	static final String PASS = "root";

	public static Connection getInstance() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

		return connection;

	}
}
