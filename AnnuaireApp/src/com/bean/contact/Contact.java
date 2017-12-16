package com.bean.contact;

import com.bean.IBean;
import com.service.LireCompteurProperties;

/**
 * La classe abstraite contact représente les informations d'une personne qui est dans l'annuaire.
 */
public abstract class Contact implements IBean, Comparable<IBean>{

	protected int id;
	protected Address address;
	protected String courriel;
	protected String telephone;
	protected String nom;
	
	public Contact() {
		super();
		this.id = LireCompteurProperties.getCompteur("contact");
	}
	
	/**
	 * Méthode d'accès à variable Adresse
	 *
	 * @return l'address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Méthode pour fixer la variables adresse.
	 *
	 * @param address la nouvelle address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Méthode d'accès à variable courriel
	 *
	 * @return le courriel
	 */
	public String getCourriel() {
		return courriel;
	}
	
	/**
	 * Méthode pour fixer la variable courriel.
	 *
	 * @param courriel the new courriel
	 */
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	
	/**
	 * Méthode d'accès à variable id
	 *
	 * @return le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Méthode d'accès à variable téléphone
	 *
	 * @return le téléphone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Méthode pour fixer la variable téléphone.
	 *
	 * @param telephone le nouveau téléphone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", address=" + address + ", courriel=" + courriel + ", telephone=" + telephone
				+ "]";
	}
	
	
}
