package com.bean.addressbook;

import java.util.HashSet;
import java.util.Set;

import com.bean.IBean;
import com.bean.compte.User;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 *
 * Représente le carnet d'adresse d'un user.
 */
public class AddressBook implements IBean {

	private static int compteur =1;
	private int id;
	
	private Set<IBean> favoris;
	private Set<IBean> listeParticuliers;
	private Set<IBean> listeEntreprises;
	
	private User user;
	
	/**
	 * Constructeur de la classe.
	 */
	public AddressBook() {
		this.id = compteur++;		
		favoris = new HashSet<IBean>();
		listeParticuliers = new HashSet<IBean>();
		listeEntreprises = new HashSet<IBean>();
	}

	/**
	 * Méthode d'accès au id du carnet d'adresse
	 * @return Le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Méthode d'accès à la liste des favoris
	 * @return La liste des favoris
	 */
	public Set<IBean> getFavoris() {
		return favoris;
	}

	/**
	 * Méthode d'accès à user.
	 * @return user
	 *
	 */
	public User getUser() {
		return user;
	}

	
	/**
	 * Méthode pour fixer la varaible user.
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
	 * @param listeParticuliers the listeParticuliers to set
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
	 * @param listeEntreprises the listeEntreprises to set
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
	
}
