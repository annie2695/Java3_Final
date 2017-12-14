package com.bean.contact;

import com.bean.IBean;

/**
 * La classe Entreprise repr�sente une entreprise dans l'annuaire.
 */
public class Entreprise extends Contact implements Comparable<IBean>{

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
		this.address.setContact(this);
		
	}

	/**
	 * M�thode d'acc�s � variable entreprise
	 *
	 * @return le nom entreprise
	 */
	public String getNomEntreprise() {
		return nomEntreprise;
	}

	/**
	 * M�thode pour fixer la variable nomEntreprise.
	 *
	 * @param nomEntreprise le nouveau nom entreprise
	 */
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	
	@Override
	public int compareTo(IBean o) {
		Entreprise e1 = (Entreprise) o;
	   return this.nomEntreprise.compareTo(e1.nomEntreprise);
	}

	@Override
	public String toString() {
		return "Entreprise [nomEntreprise=" + nomEntreprise + ", id=" + id + "]";
	}
	
	
	
}
