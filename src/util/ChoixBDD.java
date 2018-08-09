package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Reponse;

public class ChoixBDD {

//	public static Reponse getChoixByIDQuizz(int idQuestion) {
//		
//		int idQuizz = QuizzBDD.getQuizzByIDQueqtion(idQuestion).getId();
//		Connection connection = Utilities.openConnection();
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			preparedStatement = connection.prepareStatement("SELECT * FROM CHOIX WHERE ID_QUIZZ = ?;");
//			preparedStatement.setInt(1, idQuizz);
//			resultSet = preparedStatement.executeQuery();
//			List<Reponse> reps=new ArrayList<>();
//			while(resultSet.next()) {
//				
//				Reponse r = new Reponse(resultSet.getInt("ID_REPONSE"), ReponseBDD.getReponseByID(resultSet.getInt("ID_REPONSE")).getReponse());
//				reps.add(r);
//			
//			
//				
//			}
//			List<Reponse> reps2=ReponseBDD.getReponseByIDQuestion(idQuestion);
//			for(int i = 0;i<reps.size();i++) {
//				System.out.println("FOR CHOIXBDD");
//				if(reps.get(i).getId()==reps2.get(i).getId()) {
//					System.out.println("IF CHOIXBDD");
//					Reponse repon=reps2.get(i);				
//				return repon;
//				}
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} finally {
//			Utilities.closeConnexions(connection, preparedStatement, resultSet);
//		}
//		return null;
//}
	
	
	public static Reponse getChoixByIDQuestionAndParcour(int idQuestion, int idParcour) {
		
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT reponse.id_reponse, reponse.REPONSE_TEXT FROM CHOIX, REPONSE WHERE CHOIX.ID_REPONSE=REPONSE.ID_REPONSE AND ID_PARCOURS = ? AND ID_QUESTION=? ;");
			preparedStatement.setInt(1, idParcour);
			preparedStatement.setInt(2, idQuestion);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("if getchoix");
				
				Reponse r = new Reponse(resultSet.getInt("reponse.id_reponse"),resultSet.getString("reponse.REPONSE_TEXT"));
				return r;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return null;
}
	
	
	
	
	
	
	
	
public static boolean newChoixBDD(int idReponse, int idParcour) {
		
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO CHOIX (ID_REPONSE, ID_PARCOURS) VALUES (?,?)";
			preparedStatement = connection.prepareStatement(sql);
			// le res recupere les valeur de la requete
		
			
			preparedStatement.setInt(1, idReponse);
			preparedStatement.setInt(2, idParcour);
		

			// execute quesry and load result
			preparedStatement.executeUpdate();
			
			
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
		} finally {
			util.Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return false;
		
	}
}
