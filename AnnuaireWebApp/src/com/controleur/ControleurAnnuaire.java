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
import com.bean.compte.Client;
import com.bean.compte.User;
import com.service.ServiceAuthentification;
import com.service.ServiceCRUD;
import com.service.ServiceDAO;

/**
 * Servlet implementation class ControleurAnnuaire
 */
@WebServlet("/ControleurAnnuaire")
public class ControleurAnnuaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String path = "H:/Programmation/git/Java3_Final/user.xml";
	
	// Repr�sente l'instance unique d'Annuaire(Signleton)
	private Annuaire annuaire;
	
	public ControleurAnnuaire() {
		annuaire = Annuaire.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("inscription")){
			IBean newUser = new User(request.getParameter("username"), request.getParameter("psw"));
			((User) newUser).setEmail(request.getParameter("email"));
			((User) newUser).setNom(request.getParameter("lname"));
			((User) newUser).setPrenom(request.getParameter("name"));
			
			// Fonction pour envoyer un email de confirmation lors de l'inscription du nouveau user dans l'annuaire.
			
			
			annuaire.getListeUser().add((User) newUser);
			ServiceDAO.saveToXml(annuaire.getListeUser(), path);
			
			//request.setAttribute("newUser", newUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ajouterAnnuaire.jsp");
			dispatcher.forward(request, response);
		}
		if(action.equalsIgnoreCase("authentification")){
			
			int idUserTrouver = ServiceAuthentification.validateUser1(request.getParameter("username"), 
					request.getParameter("pwd"), annuaire.getListeUser());
			if(idUserTrouver != -1){
				IBean user = ServiceCRUD.getByid(idUserTrouver, annuaire.getListeUser());
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("authentification.jsp");
				dispatcher.forward(request, response);
			}
			
			
			
		}
	}	

}