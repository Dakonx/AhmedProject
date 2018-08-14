package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Competence;
import model.Quizz;
import model.User;

public class QuizzBDD {
	
	
	public static List<Quizz> getAllQuizz(){
		
		List<Quizz> quizzListe = new ArrayList<>();
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Erreur de recuperation de la connection");
			return quizzListe;
		}

		PreparedStatement st = null;
		ResultSet res = null;

		try {

			// le statement execute la requete
			String sql = "select * from QUIZZ";
			st = connection.prepareStatement(sql);
			// le statement execute la requete
			// le res recupere les valeur de la requete
			res = st.executeQuery();
			while (res.next()) {

				// System.out.println("id: " + res.getString("ID") + " email :" +
				// res.getString("LOGIN")
				// + " password :" + res.getString("PASSWORD"));
				
				quizzListe.add(new Quizz(res.getInt("id_quizz"), new Competence(res.getString("sujet")), QuestionBDD.getQuestionByIDQuizz(res.getInt("id_quizz"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, st, res);
		}
		return quizzListe;
	}

	public static Quizz getQuizzByIDQuizz(int idQuizz) {
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM QUIZZ WHERE ID_QUIZZ = ?;");
			preparedStatement.setInt(1, idQuizz);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Quizz q = new Quizz(idQuizz, new Competence(resultSet.getString("sujet")),
						QuestionBDD.getQuestionByIDQuizz(idQuizz));
				return q;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
	}

	public static Quizz getQuizzByIDQuestion(int idQuestion) {
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM QUESTION WHERE ID_QUESTION = ?;");
			preparedStatement.setInt(1, idQuestion);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Quizz q = getQuizzByIDQuizz(resultSet.getInt("id_quizz"));
				return q;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
	}

	public static Integer newQuizz(Competence comp) {

		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO QUIZZ (SUJET) VALUES (?)";
			preparedStatement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			// le res recupere les valeur de la requete

			String sujet = comp.getSujet();
			preparedStatement.setString(1, sujet);

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
		return -1;
	}

	public static List<Quizz> getQuizzBySujet(String sujet) {
		List<Quizz> quizzs = new ArrayList<Quizz>();

		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM QUIZZ WHERE SUJET = ?");
			preparedStatement.setString(1, sujet);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				quizzs.add(new Quizz(resultSet.getInt("id_quizz"), new Competence(sujet), null));

			}
			return quizzs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}

		return null;
	}
	
public static boolean modifQuizz(int id,String sujet) {
		
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;

		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "UPDATE QUIZZ SET SUJET = ? where id_QUIZZ = ?";
			st = connection.prepareStatement(sql);
			// le res recupere les valeur de la requete

			
						
			st.setString(1, sujet);
			st.setInt(2, id);

			
		

			// execute quesry and load result
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			return false;
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		return true;
	}
}
