package youtube.krishnaitprojects.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDetails {

	// JDBC URL for PostgreSQL database
	private static final String URL = "jdbc:postgresql://localhost:5432/job_project_ecommerce";

	// Database username
	private static final String USER = "postgres";

	// Database password
	private static final String PASSWORD = "1101";

	// Method to establish a database connection
	public static Connection getConnection() throws SQLException {
		// Attempt to establish a connection using DriverManager
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// Method to close a database connection
	public static void closeConnection(Connection connection) throws SQLException {
		// Check if the connection is not null before attempting to close it
		if (connection != null) {
			connection.close();
		}
	}

}
