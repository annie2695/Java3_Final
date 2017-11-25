package com.bean.contact;

/**
 * La classe 
 */
public class Particulier extends Contact {

	private String nom;
	private String prenom;
	
	/**
	 * Instancie un objet Particulier.
	 */
	public Particulier(String numeroCivique, String rue, String ville, String codePostal, String province) {
		super();
		this.address = new Address(numeroCivique, rue, ville, codePostal, province);
		
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
		return "Particulier [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}
