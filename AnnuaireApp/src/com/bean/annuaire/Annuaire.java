package com.bean.annuaire;

import java.util.Set;

import com.bean.IBean;
import com.service.ServiceDAO;

/**
 * The Class Annuaire.
 */
public class Annuaire {

	private static volatile Annuaire instance;
	private Set<IBean> listeUser;
	private Set<IBean> listeAdmin;
	private Set<IBean> listeEntreprise;
	private Set<IBean> listeParticulier;
	private static final String path = "H:/Programmation/git/Java3_Final/user.xml";

	/**
	 * Constructuer privée pour le singleton.
	 */
	private Annuaire() {
		this.listeUser = ServiceDAO.loadFromXml(path);
	}
	

	/**
	 * Retourne une instance d'Annuaire.
	 *
	 * @return l'instance de l'annuaire
	 */
	public static Annuaire getInstance() {
		// Double lock for thread safety.
		if (instance == null) {
			synchronized (Annuaire.class) {
				if (instance == null) {
					instance = new Annuaire();
				}
			}
		}
		return instance;
	}


	public Set<IBean> getListeUser() {
		return listeUser;
	}


	public void setListeUser(Set<IBean> listeUser) {
		this.listeUser = listeUser;
	}
	
}
