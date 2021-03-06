package com.bean.addressbook;

import java.util.HashSet;
import java.util.Set;

import com.bean.IBean;
import com.bean.compte.User;
import com.service.LireCompteurProperties;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 *
 *         Repr�sente le carnet d'adresse d'un user.
 */
public class AddressBook implements IBean {

	private int id;
	
	private Set<IBean> favoris;
	private Set<IBean> listeParticuliers;
	private Set<IBean> listeEntreprises;
	
	private User user;

	/**
	 * Constructeur de la classe.
	 */
	public AddressBook() {
		this.id = LireCompteurProperties.getCompteur("adressBook");		
		this.favoris = new HashSet<IBean>();
		this.listeParticuliers = new HashSet<IBean>();
		this.listeEntreprises = new HashSet<IBean>();
	}

	/**
	 * M�thode d'acc�s au id du carnet d'adresse
	 * 
	 * @return Le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�thode d'acc�s � la liste des favoris
	 * 
	 * @return La liste des favoris
	 */
	public Set<IBean> getFavoris() {
		return favoris;
	}

	/**
	 * M�thode d'acc�s � user.
	 * 
	 * @return user
	 *
	 */
	public User getUser() {
		return user;
	}

	/**
	 * M�thode pour fixer la varaible user.
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the listeParticuliers
	 */
	public Set<IBean> getListeParticuliers() {
		return listeParticuliers;
	}

	/**
	 * @param listeParticuliers
	 *            the listeParticuliers to set
	 */
	public void setListeParticuliers(Set<IBean> listeParticuliers) {
		this.listeParticuliers = listeParticuliers;
	}

	/**
	 * @return the listeEntreprises
	 */
	public Set<IBean> getListeEntreprises() {
		return listeEntreprises;
	}

	/**
	 * @param listeEntreprises
	 *            the listeEntreprises to set
	 */
	public void setListeEntreprises(Set<IBean> listeEntreprises) {
		this.listeEntreprises = listeEntreprises;
	}

	/**
	 * @param favoris the favoris to set
	 */
	public void setFavoris(Set<IBean> favoris) {
		this.favoris = favoris;
	}


	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", favoris=" + favoris + ", listeParticuliers=" + listeParticuliers
				+ ", listeEntreprises=" + listeEntreprises + ", user=" + user + "]";
	}
	
}
