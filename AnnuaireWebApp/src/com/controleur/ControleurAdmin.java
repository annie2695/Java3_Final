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
import com.bean.contact.Contact;
import com.bean.contact.Entreprise;
import com.bean.contact.Particulier;
import com.service.ServiceCRUD;
import com.service.ServiceDAO;

/**
 * Servlet implementation class ControleurAdmin
 */
@WebServlet("/ControleurAdmin")
public class ControleurAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PATH_PARTICULIER = "C:/java3/tpFinal_max_annie/sauvegarde/particulier.xml";
	private static final String PATH_ENTREPRISE = "C:/java3/tpFinal_max_annie/sauvegarde/entreprise.xml";
	private IBean contact;
	// Represente l'instance unique d'Annuaire(Singleton)
	private Annuaire annuaire;
	private RequestDispatcher dispatcher;
	
	public ControleurAdmin() {
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
		case "nouveauParticulier":
			contact = new Particulier(request.getParameter("numCivique"), request.getParameter("rue"), 
					request.getParameter("ville"), request.getParameter("postalCode"), request.getParameter("province"));
			((Contact) contact).setCourriel(request.getParameter("email"));
			((Contact) contact).setNom(request.getParameter("nom"));
			((Contact) contact).setTelephone(request.getParameter("phone"));
			((Particulier)contact).setPrenom(request.getParameter("prenom"));
			ServiceCRUD.addBean(contact, annuaire.getListeParticulier());
			ServiceDAO.saveToXml(annuaire.getListeParticulier(), PATH_PARTICULIER);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
			break;
		case "supprimeAnnuaireP":
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			ServiceCRUD.deleteBean(contact, annuaire.getListeParticulier());
			ServiceDAO.saveToXml(annuaire.getListeParticulier(), PATH_PARTICULIER);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
			break;
		case "nouveauEntreprise":
			contact = new Entreprise(request.getParameter("numCivique"), request.getParameter("rue"), 
					request.getParameter("ville"), request.getParameter("postalCode"), request.getParameter("province"));
			((Contact) contact).setCourriel(request.getParameter("email"));
			((Contact) contact).setNom(request.getParameter("nom"));
			((Contact) contact).setTelephone(request.getParameter("phone"));
			((Entreprise)contact).setNumeroEntreprise(request.getParameter("num"));
			ServiceCRUD.addBean(contact, annuaire.getListeEntreprise());
			ServiceDAO.saveToXml(annuaire.getListeEntreprise(), PATH_ENTREPRISE);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
			break;
		case "supprimeAnnuaireE":
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeEntreprise());
			ServiceCRUD.deleteBean(contact, annuaire.getListeEntreprise());
			ServiceDAO.saveToXml(annuaire.getListeEntreprise(), PATH_ENTREPRISE);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

}
