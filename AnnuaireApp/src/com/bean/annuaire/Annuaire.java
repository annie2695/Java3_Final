package com.bean.annuaire;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

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
	private static final String PATH_USERS = "C:/java3/tpFinal_max_annie/sauvegarde/user.xml";
	private static final String PATH_PARTICULIER = "C:/java3/tpFinal_max_annie/sauvegarde/particulier.xml";
	private static final String PATH_ENTREPRISE = "C:/java3/tpFinal_max_annie/sauvegarde/entreprise.xml";

	/**
	 * Constructeur privée pour le singleton.
	 */
	private Annuaire() {
		this.listeUser = ServiceDAO.loadFromXml(PATH_USERS);
		if(this.listeUser == null){
			this.listeUser = new TreeSet<>();
		}
		this.listeParticulier = ServiceDAO.loadFromXml(PATH_PARTICULIER);
		this.listeEntreprise = ServiceDAO.loadFromXml(PATH_ENTREPRISE);
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


	/**
	 * @return the listeAdmin
	 */
	public Set<IBean> getListeAdmin() {
		return listeAdmin;
	}


	/**
	 * @param listeAdmin the listeAdmin to set
	 */
	public void setListeAdmin(Set<IBean> listeAdmin) {
		this.listeAdmin = listeAdmin;
	}


	/**
	 * @return the listeEntreprise
	 */
	public Set<IBean> getListeEntreprise() {
		return listeEntreprise;
	}


	/**
	 * @param listeEntreprise the listeEntreprise to set
	 */
	public void setListeEntreprise(Set<IBean> listeEntreprise) {
		this.listeEntreprise = listeEntreprise;
	}


	/**
	 * @return the listeParticulier
	 */
	public Set<IBean> getListeParticulier() {
		return listeParticulier;
	}


	/**
	 * @param listeParticulier the listeParticulier to set
	 */
	public void setListeParticulier(Set<IBean> listeParticulier) {
		this.listeParticulier = listeParticulier;
	}
	
}
