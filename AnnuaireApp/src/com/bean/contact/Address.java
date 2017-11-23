package com.bean.contact;


/**
 * La classe address repr�sente l'adresse du contact dans l'annuaire.
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
	 * M�thode d'acc�s � variable numero civique
	 *
	 * @return le numero civique
	 */
	public String getNumeroCivique() {
		return numeroCivique;
	}

	/**
	 * M�thode pour fixer le numero civique.
	 *
	 * @param numeroCivique le nouveau numero civique
	 */
	public void setNumeroCivique(String numeroCivique) {
		this.numeroCivique = numeroCivique;
	}

	/**
	 * M�thode d'acc�s � variable rue
	 *
	 * @return la rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * M�thode pour fixer la variable rue
	 *
	 * @param rue la nouvelle rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * M�thode d'acc�s � variable ville
	 *
	 * @return la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * M�thode pour fixer la variable ville
	 *
	 * @param ville la nouvelle ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * M�thode d'acc�s � variable codePostal
	 *
	 * @return le code postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * M�thode pour fixer la variable codePostal
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
