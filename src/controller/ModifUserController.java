package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.User;

/**
 * Servlet implementation class ModifUserController
 */
public class ModifUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/modifUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idUser=Integer.parseInt(request.getParameter("iduser"));
		String modLogin = request.getParameter("modLogin");
		String modPassword = request.getParameter("modPassword");
		String modNom = request.getParameter("modNom");
		String modPrenom = request.getParameter("modPrenom");
		String modSociete = request.getParameter("modSociete");
		String modTelephone = request.getParameter("modTelephone");
		String modStatut = request.getParameter("modStatut");
		boolean statut = false;
		String erreur="";
		System.out.println(modStatut);
		if(modStatut.equals("delete")) {
			User user=new User();
			user.setId(idUser);
			Admin.deleteUser(user);
			request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request, response);
		}else if(modStatut.equals("actif")) {
			statut=true;
			
			if (modLogin.length() == 0 || modPassword.length() == 0 || modNom.length() == 0 || modPrenom.length() == 0 || modSociete.length() == 0 || modTelephone.length() == 0) {
				erreur = "un des champs est vide";
				System.out.println(erreur);
				request.getRequestDispatcher("WEB-INF/modifuser.jsp").forward(request, response);
			}else {
				Admin.modifUser(idUser, modLogin, modPassword, modNom, modPrenom, modSociete, modTelephone, statut);
			
			request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request, response);
			
			}
		}else {
			statut=false;
			
			if (modLogin.length() == 0 || modPassword.length() == 0 || modNom.length() == 0 || modPrenom.length() == 0 || modSociete.length() == 0 || modTelephone.length() == 0) {
				erreur = "un des champs est vide";
				System.out.println(erreur);
				request.getRequestDispatcher("WEB-INF/modifuser.jsp").forward(request, response);
			}else {
				Admin.modifUser(idUser, modLogin, modPassword, modNom, modPrenom, modSociete, modTelephone, statut);
			
			request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request, response);
			
			}
		}

	}
}
