package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import model.Quizz;
import model.Reponse;
import util.QuestionBDD;
import util.QuizzBDD;
import util.ReponseBDD;

/**
 * Servlet implementation class ModifQuizzController
 */
public class ModifQuizzController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/modifQuizz.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idQuizz=Integer.parseInt(String.valueOf(request.getSession().getAttribute("idQuizzModif")));
		String sujet=request.getParameter("sujet");
		System.out.println(sujet);
		QuizzBDD.modifQuizz(idQuizz, sujet);
		List<Question> questionList = QuestionBDD.getQuestionByIDQuizz(idQuizz);
		for (int i2 = 0; i2 < questionList.size(); i2++) {
			List<Reponse> reponseList = ReponseBDD.getReponseByIDQuestion(questionList.get(i2).getId());
		String intitule = request.getParameter("question"+i2);
		System.out.println(intitule);
		if(!intitule.equals("")) {
			System.out.println("je suis dans le if intitulé");
			for (int i3 = 0; i3 < reponseList.size(); i3++) {
				String reponse = request.getParameter("reponse"+i3);
				if(!reponse.equals("")) {
				ReponseBDD.modifReponse(reponseList.get(i3).getId(), reponse);
				}else{
					request.getRequestDispatcher("WEB-INF/modifQuizz.jsp").forward(request, response);
				}
				}
			int idReponseCorrect=Integer.parseInt(request.getParameter("reponsecorrect"+i2));
			QuestionBDD.modifQuestion(questionList.get(i2).getId(),intitule, idReponseCorrect);
			
		}else {
			request.getRequestDispatcher("WEB-INF/modifQuizz.jsp").forward(request, response);
		}
		}request.getRequestDispatcher("WEB-INF/quizzs.jsp").forward(request, response);
		
		
	}

}
