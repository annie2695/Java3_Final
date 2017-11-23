package com.bean.contact;


/**
 * La classe address représente l'adresse du contact dans l'annuaire.
 *
 * @author blade
 */
public class Address {

	private String numeroCivique;
	private String rue;
	private String ville;
	private String codePostal;
	private String province;
	
	/**
	 * Instancie une nouvelle adresse.
	 *
	 * @param numeroCivique the numero civique
	 * @param rue the rue
	 * @param ville the ville
	 * @param codePostal the code postal
	 */
	public Address(String numeroCivique, String rue, String ville, String codePostal, String province) {
		super();
		this.numeroCivique = numeroCivique;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.province = province;
	}

	/**
	 * Méthode d'accès à variable numero civique
	 *
	 * @return le numero civique
	 */
	public String getNumeroCivique() {
		return numeroCivique;
	}

	/**
	 * Méthode pour fixer le numero civique.
	 *
	 * @param numeroCivique le nouveau numero civique
	 */
	public void setNumeroCivique(String numeroCivique) {
		this.numeroCivique = numeroCivique;
	}

	/**
	 * Méthode d'accès à variable rue
	 *
	 * @return la rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Méthode pour fixer la variable rue
	 *
	 * @param rue la nouvelle rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Méthode d'accès à variable ville
	 *
	 * @return la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Méthode pour fixer la variable ville
	 *
	 * @param ville la nouvelle ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Méthode d'accès à variable codePostal
	 *
	 * @return le code postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Méthode pour fixer la variable codePostal
	 *
	 * @param codePostal le nouveau code postal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	@Override
	public String toString() {
		return "Adresse [numeroCivique=" + numeroCivique + ", rue=" + rue + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}
	
	
	
}
