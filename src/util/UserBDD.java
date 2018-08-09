package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserBDD {

	public static boolean userExist(String mail, String password, String table) {
		Connection connection = Utilities.openConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection
					.prepareStatement("SELECT id FROM " + table + " WHERE login = ? AND password = ?;");
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, preparedStatement, resultSet);
		}
		return false;
	}

	static public List<User> rechercherToutLesUsers() {
		List<User> liste = new ArrayList<>();
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Erreur de recuperation de la connection");
			return liste;
		}

		PreparedStatement st = null;
		ResultSet res = null;

		try {

			// le statement execute la requete
			String sql = "select * from user";
			st = connection.prepareStatement(sql);
			// le statement execute la requete
			// le res recupere les valeur de la requete
			res = st.executeQuery();
			while (res.next()) {

				// System.out.println("id: " + res.getString("ID") + " email :" +
				// res.getString("LOGIN")
				// + " password :" + res.getString("PASSWORD"));
				System.out.println(res.getInt("statut"));
				boolean statut ;
				if(res.getInt("statut")==1) {
					statut = true;
				}else{
					statut = false;
				};
				liste.add(new User(res.getInt("id"), res.getString("login"), res.getString("password"),
						res.getString("nom"), res.getString("prenom"), res.getString("societe"),
						res.getString("telephone"), res.getDate("date_creation"), statut));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, st, res);
		}
		return liste;
	}

	
	
	static public User getUserByLogin(String login) {

		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Erreur de recuperation de la connection");
		}

		PreparedStatement st = null;
		ResultSet res = null;

		try {

			// le statement execute la requete
			String sql = "select * from user where login = '" + login + "' ;";

			st = connection.prepareStatement(sql);
			// le statement execute la requete
			// le res recupere les valeur de la requete
			res = st.executeQuery();
			if (res.next()) {

				// System.out.println("id: " + res.getString("ID") + " email :" +
				// res.getString("LOGIN")
				// + " password :" + res.getString("PASSWORD"));
				User user = new User(res.getInt("id"), res.getString("login"), res.getString("password"),
						res.getString("nom"), res.getString("prenom"), res.getString("societe"),
						res.getString("telephone"), res.getDate("date_creation"), res.getBoolean("statut"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, st, res);
		}
		return null;
	}
	
	static public User getUserByID(int id) {

		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Erreur de recuperation de la connection");
		}

		PreparedStatement st = null;
		ResultSet res = null;

		try {

			// le statement execute la requete
			String sql = "select * from user where id = '" + id + "' ;";

			st = connection.prepareStatement(sql);
			// le statement execute la requete
			// le res recupere les valeur de la requete
			res = st.executeQuery();
			if (res.next()) {

				// System.out.println("id: " + res.getString("ID") + " email :" +
				// res.getString("LOGIN")
				// + " password :" + res.getString("PASSWORD"));
				User user = new User(res.getInt("id"), res.getString("login"), res.getString("password"),
						res.getString("nom"), res.getString("prenom"), res.getString("societe"),
						res.getString("telephone"), res.getDate("date_creation"), res.getBoolean("statut"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, st, res);
		}
		return null;
	}
}
