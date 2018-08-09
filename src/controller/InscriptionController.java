package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;

/**
 * Servlet implementation class InscriptionController
 */
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String insLogin = request.getParameter("insLogin");
		String insPassword = request.getParameter("insPassword");
		String insAdmin = request.getParameter("insAdmin");
		String insNom = request.getParameter("insNom");
		String insPrenom = request.getParameter("insPrenom");
		String insSociete = request.getParameter("insSociete");
		String insTelephone = request.getParameter("insTelephone");
		
		System.out.println(insAdmin);
		String erreur = "";

		if (insLogin.length() == 0 || insPassword.length() == 0) {
			erreur = "un des champs est vide";
			System.out.println(erreur);
			request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
		}else {
		if ("admin".equals(insAdmin)) {

			Admin.createAdmin(insLogin,insPassword,insNom,insPrenom,insSociete,insTelephone);
		} else {

			Admin.createUser(insLogin, insPassword,insNom,insPrenom,insSociete,insTelephone);
		}
		request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request, response);

	}
	}
}
