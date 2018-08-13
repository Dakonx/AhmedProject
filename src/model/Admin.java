package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Admin extends User {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Admin(int id, String login, String pass, String nom, String prenom, String societe, String telephone,
			Date dateCréation, Boolean statut) {
		super(id, login, pass, nom, prenom, societe, telephone, dateCréation, statut);
		// TODO Auto-generated constructor stub
	}



	public Admin(int id, String login, String pass, String nom, String prenom, String societe, String telephone,
			List<Parcour> parcours, Date dateCréation, Boolean statut) {
		super(id, login, pass, nom, prenom, societe, telephone, parcours, dateCréation, statut);
		// TODO Auto-generated constructor stub
	}



	public static boolean createUser(String login, String password, String nom, String prenom, String societe, String telephone) {
		User usr = new User (1,login, password,nom,prenom, societe,telephone,null,false);
		boolean statut = true;
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;

		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO USER (LOGIN, PASSWORD, NOM, PRENOM, SOCIETE, TELEPHONE, STATUT) VALUES (? , ?,?,?,?,?,? )";
			st = connection.prepareStatement(sql);
			// le res recupere les valeur de la requete

			String login1  = usr.getLogin();
			String password1 = usr.getPass();
			String nom1 = usr.getNom();
			String prenom1= usr.getPrenom();
			String societe1= usr.getSociete();
			String telephone1= usr.getTelephone();
			Boolean statut1 = usr.getStatut();
			int statut2=0;
			if(statut1==true) {
				statut2=1;
			}
			
			
			st.setString(1, login1);
			st.setString(2, password1);
			st.setString(3, nom1);
			st.setString(4, prenom1);
			st.setString(5, societe1);
			st.setString(6, telephone1);
			st.setInt(7, statut2);
			
		

			// execute quesry and load result
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			return false;
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		return statut;
	}
	public static boolean createAdmin(String login, String password, String nom, String prenom, String societe, String telephone) {
		Admin adm = new Admin (1, login,  password,  nom,  prenom,  societe,  telephone,null, true);
		
		boolean statut = true;
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;

		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "INSERT INTO ADMIN (LOGIN, PASSWORD, NOM, PRENOM, SOCIETE, TELEPHONE, STATUT) VALUES (?,?,?,?,?,?,?)";
			st = connection.prepareStatement(sql);
			// le res recupere les valeur de la requete
		
			String login1  = adm.getLogin();
			String password1 = adm.getPass();
			String nom1 = adm.getNom();
			String prenom1= adm.getPrenom();
			String societe1= adm.getSociete();
			String telephone1= adm.getTelephone();
			Boolean statut1 = adm.getStatut();
			int statut2=0;
			if(statut1==true) {
				statut2=1;
			}
			
			
			st.setString(1, login1);
			st.setString(2, password1);
			st.setString(3, nom1);
			st.setString(4, prenom1);
			st.setString(5, societe1);
			st.setString(6, telephone1);
			st.setInt(7, statut2);
		

			// execute quesry and load result
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			return false;
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		return statut;
	}
	
	
	public static boolean activeUser(User user) {
		boolean statut = true;
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;
		
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String login = user.getLogin();
			String sql = "UPDATE USER SET statut = true where login = '"+login+"'";
			System.out.println(user.getLogin());
			//st.setString(1, user.getLogin());
			st = connection.prepareStatement(sql);
			
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			return false;
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		return statut;
	}
	
	public static boolean desactiveUser(User user) {
		boolean statut = true;
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;
		
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String login = user.getLogin();
			String sql = "UPDATE USER SET statut = false where login = '"+login+"'";
			System.out.println(user.getLogin());
			//st.setString(1, user.getLogin());
			st = connection.prepareStatement(sql);
			
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			return false;
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		return statut;
	}
	
	public static boolean deleteUser(User user) {
		boolean statut = true;
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;
		
		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			int id = user.getId();
			String sql = "DELETE FROM USER where login = '"+id+"'";
			System.out.println(user.getLogin());
			//st.setString(1, user.getLogin());
			st = connection.prepareStatement(sql);
			
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème lors de la connexion à la BD");
			e.printStackTrace();
			return false;
		} finally {
			util.Utilities.closeConnexions(connection, st, res);
		}
		return statut;
	}

	
	public static boolean modifUser(int id, String login, String password, String nom, String prenom, String societe, String telephone, boolean statut) {
		User usr = new User (id ,login, password,nom,prenom, societe,telephone,null,statut);
		Connection connection = null;
		// statelent execute la requete
		PreparedStatement st = null;
		// recupere les resulat de la requete
		ResultSet res = null;

		try {

			connection = util.Utilities.openConnection();
			System.out.println("Connection etablie");

			// le statement execute la requete
			String sql = "UPDATE USER SET LOGIN = ?, PASSWORD = ?, NOM = ?, PRENOM = ?, SOCIETE = ?, TELEPHONE = ?, STATUT= ? where id = ?";
			st = connection.prepareStatement(sql);
			// le res recupere les valeur de la requete

			String login1  = usr.getLogin();
			String password1 = usr.getPass();
			String nom1 = usr.getNom();
			String prenom1= usr.getPrenom();
			String societe1= usr.getSociete();
			String telephone1= usr.getTelephone();
			Boolean statut1 = usr.getStatut();
			int id1 = usr.getId();
			int statut2=0;
			if(statut1==true) {
				statut2=1;
			}
			
			
			st.setString(1, login1);
			st.setString(2, password1);
			st.setString(3, nom1);
			st.setString(4, prenom1);
			st.setString(5, societe1);
			st.setString(6, telephone1);
			st.setInt(7, statut2);
			st.setInt(8, id1);
			
		

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
