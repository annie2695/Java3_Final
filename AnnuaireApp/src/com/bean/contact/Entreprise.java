package com.bean.contact;

import com.bean.IBean;

/**
 * La classe Entreprise représente une entreprise dans l'annuaire.
 */
public class Entreprise extends Contact{

	private String numeroEntreprise;
	
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
		this.address.setContact(this);
	}

	/**
	 * @return the numeroEntreprise
	 */
	public String getNumeroEntreprise() {
		return numeroEntreprise;
	}

	/**
	 * @param numeroEntreprise the numeroEntreprise to set
	 */
	public void setNumeroEntreprise(String numeroEntreprise) {
		this.numeroEntreprise = numeroEntreprise;
	}

	@Override
	public int compareTo(IBean c) {
		return this.nom.compareTo(((Contact)c).getNom());
	}
	
}
