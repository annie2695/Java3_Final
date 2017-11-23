package com.bean.contact;

/**
 * La classe Entreprise représente une entreprise dans l'annuaire.
 */
public class Entreprise extends Contact {

	private String nomEntreprise;
	
	/**
	 * Instancie une nouvelle entreprise.
	 *
	 * @param numeroCivique le numero civique
	 * @param rue la rue
	 * @param ville la ville
	 * @param codePostal le code postal
	 * @param province la province
	 */
	public Entreprise(String numeroCivique, String rue, String ville, String codePostal, String province) {
		super();
		this.address = new Address(numeroCivique, rue, ville, codePostal, province);
		
	}

	/**
	 * Méthode d'accès à variable entreprise
	 *
	 * @return le nom entreprise
	 */
	public String getNomEntreprise() {
		return nomEntreprise;
	}

	/**
	 * Méthode pour fixer la varaible nomEntreprise.
	 *
	 * @param nomEntreprise le nouveau nom entreprise
	 */
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	
	
	
}
