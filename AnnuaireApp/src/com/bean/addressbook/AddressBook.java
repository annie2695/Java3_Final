package com.bean.addressbook;

import java.util.Set;
import java.util.TreeSet;

import com.bean.IBean;
import com.bean.compte.User;
import com.bean.contact.Contact;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 *
 * Représente le carnet d'adresse d'un user.
 */
public class AddressBook implements IBean {

	private static int compteur =1;
	private int id;
	
	private Set<Contact> favoris;
	private Set<Contact> listeParticuliers;
	private Set<Contact> listeEntreprises;
	
	private User user;
	
	/**
	 * Constructeur de la classe.
	 */
	public AddressBook() {
		this.id = compteur;
		compteur++;
		
		favoris = new TreeSet<Contact>();
		listeParticuliers = new TreeSet<Contact>();
		listeEntreprises = new TreeSet<Contact>();
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
	public Set<Contact> getFavoris() {
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
	public Set<Contact> getListeParticuliers() {
		return listeParticuliers;
	}

	/**
	 * @param listeParticuliers the listeParticuliers to set
	 */
	public void setListeParticuliers(Set<Contact> listeParticuliers) {
		this.listeParticuliers = listeParticuliers;
	}

	/**
	 * @return the listeEntreprises
	 */
	public Set<Contact> getListeEntreprises() {
		return listeEntreprises;
	}

	/**
	 * @param listeEntreprises the listeEntreprises to set
	 */
	public void setListeEntreprises(Set<Contact> listeEntreprises) {
		this.listeEntreprises = listeEntreprises;
	}
	
}
