package com.bean.contact;

import com.bean.IBean;

/**
 * La classe 
 */
public class Particulier extends Contact implements Comparable<IBean> {

	private String nom;
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
	 * Méthode d'accès à variable nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode pour fixer le nom.
	 *
	 * @param nom le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
		return "Particulier [id= " + super.id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	@Override
	public int compareTo(IBean o) {
		Particulier p1 = (Particulier) o;
		if(this.nom.equals(p1.nom))
	    {
	      return this.prenom.compareTo(p1.prenom);
	    }
	   return this.nom.compareTo(p1.nom);
	}
	
	
	
}
