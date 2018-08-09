package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilities {

	
	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/exercise";
		String user = "root";
		String password = "";
		// connexion etablit
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver chargé");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection etablie");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public static void  closeConnexions(Connection connection, PreparedStatement st, ResultSet res) {
		try {
			if (res != null) {
				res.close();
			}
			if (st != null) {
				st.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
