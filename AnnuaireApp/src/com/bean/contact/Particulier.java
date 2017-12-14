package com.bean.contact;

import com.bean.IBean;

/**
 * La classe 
 */
public class Particulier extends Contact {
	
	private String prenom;
	
	/**
	 * Instancie un objet Particulier.
	 */
	public Particulier(String numeroCivique, String rue, String ville, String codePostal, String province) {
		super();
		this.address = new Address(numeroCivique, rue, ville, codePostal, province);
		this.address.setContact(this);
	}

	/**
	 * Méthode d'accès à variable prenom.
	 *
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode pour fixer la variable prenom
	 *
	 * @param prenom le nouveau prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Particulier [id= " + super.id + ", prenom=" + prenom + "]";
	}
	
	@Override
	public int compareTo(IBean c) {
		return this.nom.compareTo(((Contact)c).getNom());
	}
	
}
