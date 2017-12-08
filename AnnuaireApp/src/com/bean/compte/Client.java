package com.bean.compte;

import com.bean.IBean;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 *
 * Repr�sente une personne qui utilise notre syst�me. Peut �tre
 * 	<i>Admin</i> (personne qui g�re le syst�me) ou <i>User</i>
 * 	(personne qui consulte le syst�me).
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
	 * M�thode d'acc�s au id du client
	 * @return le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�thode d'acc�s au nom du client
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * M�thode qui fixe le nom du client
	 * @param nom Le nom � fixer.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * M�thode d'acc�s au pr�nom du client
	 * @return le pr�nom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * M�thode qui fixe le pr�nom du client
	 * @param prenom Le pr�nom � fixer
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * M�thode d'acc�s au email du client
	 * @return le email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M�thode qui fixe le email du client
	 * @param email Le email � fixer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
}
