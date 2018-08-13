package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import model.Quizz;
import model.Reponse;
import model.User;
import util.ChoixBDD;
import util.ParcoursBDD;
import util.QuestionBDD;
import util.ReponseBDD;
import util.UserBDD;

/**
 * Servlet implementation class FaireQuizzController
 */
@WebServlet("/fairequizz")
public class FaireQuizzController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/faireQuizz.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long fin = System.currentTimeMillis();
		long tempsQuizz=fin-(long)request.getSession().getAttribute("debut");
		
		List<Question> quests = QuestionBDD.getQuestionByIDQuizz(Integer.parseInt((String) request.getSession().getAttribute("idQuizzSelect")));

		int score = 0;

		for (int i = 0; i < quests.size(); i++) {
			@SuppressWarnings("unused")
			List<Reponse> reponses = ReponseBDD.getReponseByIDQuestion(quests.get(i).getId());

			String nameR = "choixQ" + i;
			int idChoix = Integer.parseInt(request.getParameter(nameR));

			if (idChoix == quests.get(i).getReponseCorrect().getId()) {
				score++;

			}
			System.out.println(idChoix+" == "+quests.get(i).getReponseCorrect().getId());

		}
		Quizz quizz = new Quizz(Integer.parseInt((String) request.getSession().getAttribute("idQuizzSelect")), null, null);
		User user = UserBDD.getUserByLogin((String) request.getSession().getAttribute("login"));
		int idParcour=ParcoursBDD.newParcourBDD(quizz, user, score, tempsQuizz);
		
		for (int i = 0; i < quests.size(); i++) {
			String nameR = "choixQ" + i;
			int idChoix = Integer.parseInt(request.getParameter(nameR));
			ChoixBDD.newChoixBDD(idChoix, idParcour);
		}
		
		request.getRequestDispatcher("WEB-INF/accueilUser.jsp").forward(request, response);

	}

}
