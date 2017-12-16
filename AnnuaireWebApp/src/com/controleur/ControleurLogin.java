package com.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.IBean;
import com.bean.annuaire.Annuaire;
import com.bean.compte.User;
import com.service.MailService;
import com.service.ServiceAuthentification;
import com.service.ServiceCRUD;
import com.service.ServiceDAO;

/**
 * Servlet implementation class ControleurLogin
 */
@WebServlet("/ControleurLogin")
public class ControleurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PATH_USER = "C:/java3/tpFinal_max_annie/sauvegarde/user.xml";
	private IBean user;
	// Represente l'instance unique d'Annuaire(Singleton)
	private Annuaire annuaire;
	private RequestDispatcher dispatcher;

    public ControleurLogin() {
    	annuaire = Annuaire.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "inscription":
			if(ServiceAuthentification.validerMotDePasse(request.getParameter("psw"), request.getParameter("psw-repeat"))) {
				user = new User(request.getParameter("username"), request.getParameter("psw"));
				((User) user).setEmail(request.getParameter("email"));
				((User) user).setNom(request.getParameter("lname"));
				((User) user).setPrenom(request.getParameter("name"));
				
				if(ServiceCRUD.addBean(user, annuaire.getListeUser())) {
					// traitement pour envoyer un email de confirmation lors de l'inscription du nouveau user dans l'annuaire.
						MailService mailService = new MailService();
						mailService.sendMail("test@test.ca", request.getParameter("email"), "Test Mail From TpFinal", "test01");	
				}		
				ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
				
				
				dispatcher = request.getRequestDispatcher("ajouterAnnuaire.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("erreurInscription.jsp");
				dispatcher.forward(request, response);
			}
			break;
		case "authentification":
			if (request.getParameter("username").charAt(0) == 'u') {
				int idUserTrouver = ServiceAuthentification.validateUser(request.getParameter("username"), 
						request.getParameter("pwd"), annuaire.getListeUser());
				if(idUserTrouver != -1){
					user = ServiceCRUD.getByid(idUserTrouver, annuaire.getListeUser());
					request.setAttribute("user", user);
					dispatcher = request.getRequestDispatcher("accueilUser.jsp");
					dispatcher.forward(request, response);
				}
			}else if (request.getParameter("username").charAt(0) == 'a') {
				int idAdminTrouver = ServiceAuthentification.validateAdmin(request.getParameter("username"), 
						request.getParameter("pwd"), annuaire.getListeAdmin());
				if(idAdminTrouver != -1){
					IBean admin = ServiceCRUD.getByid(idAdminTrouver, annuaire.getListeAdmin());
					request.setAttribute("admin", admin);
					dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
					dispatcher.forward(request, response);
				}
			}
			else{
				dispatcher = request.getRequestDispatcher("erreurLogin.jsp");
				dispatcher.forward(request, response);
			}
			break;
		default:
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

}
