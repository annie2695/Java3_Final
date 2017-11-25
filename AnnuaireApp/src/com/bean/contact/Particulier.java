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
	 * M�thode d'acc�s � variable nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * M�thode pour fixer le nom.
	 *
	 * @param nom le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * M�thode d'acc�s � variable prenom.
	 *
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * M�thode pour fixer la variable prenom
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
