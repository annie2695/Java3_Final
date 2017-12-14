package com.controleur;

import java.io.IOException;

import javax.mail.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.IBean;
import com.bean.annuaire.Annuaire;
import com.bean.compte.User;
import com.bean.contact.Contact;
import com.bean.contact.Entreprise;
import com.bean.contact.Particulier;
import com.service.MailService;
import com.service.ServiceAuthentification;
import com.service.ServiceCRUD;
import com.service.ServiceDAO;

/**
 * Servlet implementation class ControleurAnnuaire
 */
@WebServlet("/ControleurAnnuaire")
public class ControleurAnnuaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH_USER = "C:/java3/tpFinal_max_annie/sauvegarde/user.xml";
	private static final String PATH_PARTICULIER = "C:/java3/tpFinal_max_annie/sauvegarde/particulier.xml";
	private static final String PATH_ENTREPRISE = "C:/java3/tpFinal_max_annie/sauvegarde/entreprise.xml";
	private IBean user;
	
	// Represente l'instance unique d'Annuaire(Singleton)
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
			
			if(ServiceCRUD.addBean(newUser, annuaire.getListeUser())) {
				// traitement pour envoyer un email de confirmation lors de l'inscription du nouveau user dans l'annuaire.
					MailService mailService = new MailService();
					mailService.sendMail("test@test.ca", request.getParameter("email"), "Test Mail From TpFinal", "test01");	
			}		
			ServiceDAO.saveToXml(annuaire.getListeUser(), PATH_USER);
			
			//request.setAttribute("newUser", newUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ajouterAnnuaire.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equalsIgnoreCase("authentification")){
			if (request.getParameter("username").charAt(0) == 'u') {
				int idUserTrouver = ServiceAuthentification.validateUser(request.getParameter("username"), 
						request.getParameter("pwd"), annuaire.getListeUser());
				if(idUserTrouver != -1){
					user = ServiceCRUD.getByid(idUserTrouver, annuaire.getListeUser());
					request.setAttribute("user", user);
					RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
					dispatcher.forward(request, response);
				}
			}else if (request.getParameter("username").charAt(0) == 'a') {
				int idAdminTrouver = ServiceAuthentification.validateAdmin(request.getParameter("username"), 
						request.getParameter("pwd"), annuaire.getListeAdmin());
				if(idAdminTrouver != -1){
					IBean admin = ServiceCRUD.getByid(idAdminTrouver, annuaire.getListeAdmin());
					request.setAttribute("admin", admin);
					RequestDispatcher dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		}
		else if(action.equalsIgnoreCase("consulterAnnuaire")){
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("annuaire.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("supprimeParticulier")) {
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeParticuliers());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeParticuliers());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("AjoutFavorisP")) {
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			//IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					//((User)user).getAddressBook().getListeParticuliers());
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeParticuliers());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("supprimeEntreprise")) {
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeEntreprises());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeEntreprises());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equalsIgnoreCase("supprimeFavorisParticulier")){
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());			
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getListeParticuliers());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("supprimeFavorisEntreprise")){
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeEntreprise());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getListeEntreprises());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("AjoutFavorisE")) {
			user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), Annuaire.getInstance().getListeUser());
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), 
					((User)user).getAddressBook().getListeEntreprises());
			ServiceCRUD.addBean(contact, ((User)user).getAddressBook().getFavoris());
			ServiceCRUD.deleteBean(contact, ((User)user).getAddressBook().getListeEntreprises());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equalsIgnoreCase("ajouterParticulier")){
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			IBean user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			ServiceCRUD.addBean(contact, ((User) user).getAddressBook().getListeParticuliers());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equalsIgnoreCase("ajouterEntreprise")){
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeEntreprise());
			IBean user = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("user")), annuaire.getListeUser());
			ServiceCRUD.addBean(contact, ((User) user).getAddressBook().getListeEntreprises());
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilUser.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("supprimeAnnuaireP")) {
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeParticulier());
			ServiceCRUD.deleteBean(contact, annuaire.getListeParticulier());
			ServiceDAO.saveToXml(annuaire.getListeParticulier(), PATH_PARTICULIER);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("supprimeAnnuaireE")) {
			IBean contact = ServiceCRUD.getByid(Integer.parseInt(request.getParameter("contact")), annuaire.getListeEntreprise());
			ServiceCRUD.deleteBean(contact, annuaire.getListeEntreprise());
			ServiceDAO.saveToXml(annuaire.getListeEntreprise(), PATH_ENTREPRISE);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("nouveauParticulier")) {
			Contact c = new Particulier(request.getParameter("numCivique"), request.getParameter("rue"), 
					request.getParameter("ville"), request.getParameter("postalCode"), request.getParameter("province"));
			c.setCourriel(request.getParameter("email"));
			c.setNom(request.getParameter("nom"));
			c.setTelephone(request.getParameter("phone"));
			((Particulier)c).setPrenom(request.getParameter("prenom"));
			ServiceCRUD.addBean(c, annuaire.getListeParticulier());
			ServiceDAO.saveToXml(annuaire.getListeParticulier(), PATH_PARTICULIER);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.equalsIgnoreCase("nouveauEntreprise")) {
			Contact c = new Entreprise(request.getParameter("numCivique"), request.getParameter("rue"), 
					request.getParameter("ville"), request.getParameter("postalCode"), request.getParameter("province"));
			c.setCourriel(request.getParameter("email"));
			c.setNom(request.getParameter("nom"));
			c.setTelephone(request.getParameter("phone"));
			((Entreprise)c).setNumeroEntreprise(request.getParameter("num"));
			ServiceCRUD.addBean(c, annuaire.getListeEntreprise());
			ServiceDAO.saveToXml(annuaire.getListeEntreprise(), PATH_ENTREPRISE);
			request.setAttribute("admin", ServiceCRUD.getByid(Integer.parseInt(request.getParameter("admin")), annuaire.getListeAdmin()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("accueilAdmin.jsp");
			dispatcher.forward(request, response);
		}
	}	
}
