package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Parcour;
import model.Quizz;
import model.User;

public class ParcoursBDD {

	
	public static List<Parcour> getParcoursByIDUser(int idUser) {
		List<Parcour> parcours = new ArrayList<>();
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM PARCOURS WHERE ID_USER = ?;");
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Parcour p1 = new Parcour(resultSet.getInt("ID_PARCOURS"), QuizzBDD.getQuizzByIDQuizz(resultSet.getInt("ID_QUIZZ")), resultSet.getInt("SCORE"), resultSet.getFloat("TEMPS"));
				parcours.add(p1);
			}
			return parcours;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
}
	
	public static Integer newParcourBDD(Quizz quizz, User user, int score, long temps) {
		
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO PARCOURS (ID_QUIZZ, ID_USER, SCORE, TEMPS) VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// le res recupere les valeur de la requete
		
			
			preparedStatement.setInt(1, quizz.getId());
			preparedStatement.setInt(2, user.getId());
			preparedStatement.setInt(3, score);
			preparedStatement.setLong(4, temps);
		

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
