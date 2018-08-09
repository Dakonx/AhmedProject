package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Competence;
import util.QuestionBDD;
import util.QuizzBDD;
import util.ReponseBDD;

/**
 * Servlet implementation class CreationQuizzController
 */
public class CreationQuizzController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/creationQuizz.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idQuizz = -1;
		String sujet = request.getParameter("sujet");
		if (!sujet.equals("")) {
			Competence comp = new Competence(sujet);
			idQuizz = QuizzBDD.newQuizz(comp);
		} else {
			System.out.println("LOL");
			request.getRequestDispatcher("WEB-INF/creationQuizz.jsp").forward(request, response);
		}

			for (int i = 1; i < 4/* nombre de question */; i++) {

				String quest = request.getParameter("question" + i);
				int idQuestion = -1;
				if (!quest.equals("")||idQuizz!=-1) {

					idQuestion = QuestionBDD.newQuestionBDD(quest, idQuizz);
				} else {
					request.getRequestDispatcher("WEB-INF/creationQuizz.jsp").forward(request, response);
				}
				for (int j = 1; j < 4/* nombre de reponse */; j++) {

					String reponse = request.getParameter("reponse" + j + "q" + i);
					Integer idReponse = -1;
					if (!reponse.equals("") || idQuestion != -1) {

						idReponse = ReponseBDD.newReponseBDD(reponse, idQuestion);

					} else {
						request.getRequestDispatcher("WEB-INF/creationQuizz.jsp").forward(request, response);
					}

					String reponseCorrect = request.getParameter("reponseq" + i);
					if (!reponseCorrect.equals("") || idQuestion != -1 || idReponse != -1) {

						if (Integer.valueOf(reponseCorrect).equals(j)) {
							QuestionBDD.newQuestionBDD2(idReponse, idQuestion);
						}
					} else {
						request.getRequestDispatcher("WEB-INF/creationQuizz.jsp").forward(request, response);
					}
				}
			}
			request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request, response);
	}

}
