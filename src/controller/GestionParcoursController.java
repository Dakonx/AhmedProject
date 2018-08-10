package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.User;
import util.UserBDD;

/**
 * Servlet implementation class GestionParcoursController
 */
public class GestionParcoursController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/gestionParcours.jsp").forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] select =request.getParameterValues("userSelected");
		System.out.println("je suis dans gestionparcours");
		
		for(int i=0;i<select.length;i++) {
			int select1=Integer.parseInt(select[i]);
			
			System.out.println(select1);
			User user = UserBDD.getUserByID(select1);
			//System.out.println(user.getLogin());
			if(request.getParameter("acti").equals("desactiver")) {
				
			
			Admin.desactiveUser(user);
			}else if(request.getParameter("activ").equals("delete")){
				
				//methode suppr user
			Admin.deleteUser(user);
			}
		}
		doGet(request,response);
	}

}
