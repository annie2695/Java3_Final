package com.bean.contact;

import com.bean.IBean;

/**
 * La classe abstraite contact repr�sente les informations d'une personne qui est dans l'annuaire.
 */
public abstract class Contact implements IBean {

	protected static int compteur = 1;
	protected int id;
	protected Address address;
	protected String courriel;
	protected String telephone;
	
	public Contact() {
		super();
		this.id = compteur++;
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
	
	
}
