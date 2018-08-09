package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.Question;

public class QuestionBDD {

	
	public static List<Question> getQuestionByIDQuizz(int idQuizz) {
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Question> qss = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM QUESTION WHERE ID_QUIZZ = ?;");
			preparedStatement.setInt(1, idQuizz );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Question q1 = new Question(resultSet.getInt("ID_QUESTION"), resultSet.getString("INTITULE"), ReponseBDD.getReponseByID(resultSet.getInt("ID_Reponse_correct")));
				qss.add(q1);
			}
			return qss;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
	}
	
	public static int newQuestionBDD( String intitule, int idQuizz ) {

		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO QUESTION (INTITULE, ID_QUIZZ) VALUES (?,?)";
			preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, intitule);
			preparedStatement.setInt(2, idQuizz);
			
			// le res recupere les valeur de la requete
		
			
		

			// execute quesry and load result
			preparedStatement.executeUpdate();
			resultSet= preparedStatement.getGeneratedKeys();
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
	
	public static int lastIdQuestion() {
		
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT MAX(id_question) FROM QUESTION;");
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int idQuestion=resultSet.getInt("id_question");
				return idQuestion;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return 0;
		
	}
	
	public static void newQuestionBDD2(int idReponse, int idQuestion) {
		
		
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;
		
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			
			String sql = "UPDATE QUESTION SET id_reponse_correct = ? where id_question = ?";
			
			
			
			st = connection.prepareStatement(sql);
			st.setInt(1, idReponse);
			st.setInt(2, idQuestion);
			
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		
		
	}
}
