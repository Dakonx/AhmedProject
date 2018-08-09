package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import util.UserBDD;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String admin = request.getParameter("admin");

		// ===============================
		String erreur = "";
		User user = UserBDD.getUserByLogin(login);

		if (admin != null && !"".equals(admin) && UserBDD.userExist(login, password, admin)) {
			if ("admin".equals(admin)) {
				request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request, response);
			} else if (user.getStatut()) {
				request.getSession().setAttribute("login", login);
				request.getRequestDispatcher("WEB-INF/accueilUser.jsp").forward(request, response);
			} else {
				erreur = "compte inactif";
				System.out.println(erreur);
				doGet(request, response);
			}
		} else {
			erreur = "login ou password incorrect";
			doGet(request, response);
		}

		// ===============================

		// boolean adminb = false;
		// System.out.println(admin);
		// List<Admin> listA = BDD.rechercherToutLesAdmins();
		// List<User> listU = BDD.rechercherToutLesUsers();
		// if ("admin".equals(admin)) {
		// adminb = true;
		// }
		//
		// String erreur = "";
		//
		// if (login.length() == 0 || password.length() == 0 || admin == null) {
		// erreur = "un des champs est vide";
		//
		// request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		// } else {
		//
		// for (int i = 0; i < listA.size(); i++) {
		// if (login.equals(listA.get(i).getLogin()) &&
		// password.equals(listA.get(i).getPass())
		// && adminb == true) {
		// System.out.println("connection non admin admin reussie");
		// request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request,
		// response);
		// }
		// }
		//
		// if ("admin".equals(login) && "admin".equals(password) && adminb == true) {
		//
		// request.getRequestDispatcher("WEB-INF/gestion.jsp").forward(request,
		// response);
		// } else {
		//
		// for (int i = 0; i < listU.size(); i++) {
		// if (login.equals(listU.get(i).getLogin()) &&
		// password.equals(listU.get(i).getPass())
		// && adminb == false) {
		//
		// request.getRequestDispatcher("WEB-INF/accueilUser.jsp").forward(request,
		// response);
		// }
		// }
		// erreur = "login ou password incorrect";
		// request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		// }
		// }

	}
}
