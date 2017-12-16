package com.bean.contact;

import com.bean.IBean;
import com.service.LireCompteurProperties;

/**
 * La classe abstraite contact repr�sente les informations d'une personne qui est dans l'annuaire.
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
	 * M�thode d'acc�s � variable Adresse
	 *
	 * @return l'address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * M�thode pour fixer la variables adresse.
	 *
	 * @param address la nouvelle address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * M�thode d'acc�s � variable courriel
	 *
	 * @return le courriel
	 */
	public String getCourriel() {
		return courriel;
	}
	
	/**
	 * M�thode pour fixer la variable courriel.
	 *
	 * @param courriel the new courriel
	 */
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	
	/**
	 * M�thode d'acc�s � variable id
	 *
	 * @return le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�thode d'acc�s � variable t�l�phone
	 *
	 * @return le t�l�phone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * M�thode pour fixer la variable t�l�phone.
	 *
	 * @param telephone le nouveau t�l�phone
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
