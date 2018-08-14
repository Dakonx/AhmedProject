package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Competence;
import model.Quizz;

public class CompetenceBDD {

	public static List<Competence> getAllCompetence() {

		List<Competence> competenceListe = new ArrayList<>();
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Erreur de recuperation de la connection");
			return competenceListe;
		}

		PreparedStatement st = null;
		ResultSet res = null;

		try {

			// le statement execute la requete
			String sql = "select * from ";
			st = connection.prepareStatement(sql);
			// le statement execute la requete
			// le res recupere les valeur de la requete
			res = st.executeQuery();
			while (res.next()) {

				// System.out.println("id: " + res.getString("ID") + " email :" +
				// res.getString("LOGIN")
				// + " password :" + res.getString("PASSWORD"));

				competenceListe.add(new Competence(res.getString("sujet")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnexions(connection, st, res);
		}
		return competenceListe;
	}

}
