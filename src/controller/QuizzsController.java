package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizzsController
 */
public class QuizzsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/quizzs.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String select =request.getParameter("quizzAModifier");
		System.out.println("je suis dans Quizzs");
		
			if(!select.equals(null)) {
			int idQuizzModif=Integer.parseInt(select);
			
			request.getSession().setAttribute("idQuizzModif", idQuizzModif);
			
			request.getRequestDispatcher("WEB-INF/modifQuizz.jsp").forward(request, response);
			
				
			
			}else {
			
			doGet(request,response);}
	}

}

