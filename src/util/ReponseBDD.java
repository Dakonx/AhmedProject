package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Reponse;

public class ReponseBDD {

	public static List<Reponse> getReponseByIDQuestion(int idQuestion) {
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM REPONSE WHERE ID_QUESTION = ?;");
			preparedStatement.setInt(1, idQuestion);
			resultSet = preparedStatement.executeQuery();
			List<Reponse> reps=new ArrayList<>();
			while(resultSet.next()) {
				Reponse r = new Reponse(resultSet.getInt("ID_REPONSE"), resultSet.getString("REPONSE_TEXT"));
				reps.add(r);
			}
			return reps;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
}
	
	public static Reponse getReponseByID(int id) {
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM REPONSE WHERE ID_REPONSE = ?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Reponse r = new Reponse(id, resultSet.getString("REPONSE_TEXT"));
				return r;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
}
	public static Integer newReponseBDD(String reponse, int idQuestion) {
		
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO REPONSE (REPONSE_TEXT, ID_QUESTION) VALUES (?,?)";
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// le res recupere les valeur de la requete
		
			
			preparedStatement.setString(1, reponse);
			preparedStatement.setInt(2, idQuestion);
		

			// execute quesry and load result
			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			return resultSet.getInt(1);
			
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
		} finally {
			util.Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
		
	}
	
	
}
