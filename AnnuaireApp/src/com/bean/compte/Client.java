package com.bean.compte;

import com.bean.IBean;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 *
 * Représente une personne qui utilise notre système. Peut être
 * 	<i>Admin</i> (personne qui gère le système) ou <i>User</i>
 * 	(personne qui consulte le système).
 */
public abstract class Client implements IBean {
	
	protected static int compteur = 1;
	protected int id;
	
	private String nom, prenom;
	private String email;
	
	/**
	 * Constructeur de la classe.
	 */
	public Client() {
		this.id = compteur++;
	}

	/**
	 * Méthode d'accès au id du client
	 * @return le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Méthode d'accès au nom du client
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode qui fixe le nom du client
	 * @param nom Le nom à fixer.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode d'accès au prénom du client
	 * @return le prénom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode qui fixe le prénom du client
	 * @param prenom Le prénom à fixer
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Méthode d'accès au email du client
	 * @return le email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Méthode qui fixe le email du client
	 * @param email Le email à fixer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
}
