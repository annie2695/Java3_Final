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
import com.service.ServiceCRUD;
import com.service.ServiceDAO;
import com.service.ServicePDF;

/**
 * Servlet implementation class ControleurUser
 */
@WebServlet("/ControleurUser")
public class ControleurUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PATH_USER = "C:/java3/tpFinal_max_annie/sauvegarde/user.xml";
	private IBean user, contact;
	// Represente l'instance unique d'Annuaire(Singleton)
	private Annuaire annuaire;
	private RequestDispatcher dispatcher;
	
       
    public ControleurUser() {
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
		case "consulterAnnuaire":
			request.setAttribute("user", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser()));
			dispatcher = request.getRequestDispatcher("annuaire.jsp");
			dispatcher.forward(request, response);
			break;
		case "ajouterParticulier":
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			ServiceCRUD.addBean(contact, ((User) user).getAddressBook().getListeParticuliers());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "supprimeParticulier":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeParticuliers());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeParticuliers());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "AjoutFavorisP":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeParticuliers());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeParticuliers());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "supprimeFavorisParticulier":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());			
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getListeParticuliers());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		case "ajouterEntreprise":
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeEntreprise());
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			ServiceCRUD.addBean(contact, ((User) user).getAddressBook().getListeEntreprises());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "supprimeEntreprise":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeEntreprises());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeEntreprises());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "ajoutFavorisE":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeEntreprises());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeEntreprises());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "supprimeFavorisEntreprise":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeEntreprise());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getListeEntreprises());
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "generePDF":
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			ServicePDF.generePDF((User) user);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

}
