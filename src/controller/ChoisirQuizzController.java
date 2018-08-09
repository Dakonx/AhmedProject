package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 * Servlet implementation class ChoisirQuizzController
 */
public class ChoisirQuizzController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/choisirQuizz.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idQuizzSelect = request.getParameter("quizz");
		long debut = System.currentTimeMillis();
		request.getSession().setAttribute("debut", debut);
		if(!idQuizzSelect.equals("")) {
		request.getSession().setAttribute("idQuizzSelect", idQuizzSelect);
		
		request.getRequestDispatcher("WEB-INF/faireQuizz.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/choisirQuizz.jsp").forward(request, response);
		}
		
		
		
		
	}

}
