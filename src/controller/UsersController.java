package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersController
 */
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/Users.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select =request.getParameter("userAModifier");
		System.out.println("je suis dans Users");
		
			if(!select.equals("")) {
			int idUserModif=Integer.parseInt(select);
			
			request.getSession().setAttribute("idUserModif", idUserModif);
			
			request.getRequestDispatcher("WEB-INF/modifUser.jsp").forward(request, response);
			
				
			
			}else {
			
			doGet(request,response);}
		}


}
