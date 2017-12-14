package com.bean.compte;

import java.util.Map;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 * 
 * Classe donnant un nom d'utilisateur et un mot de passe
 * aux utilisateurs du système.
 */
public class Credentials {
	
	private int id;
	private String username, pwd;
	
	private static int compteur = 1;
	
	private Map<String, String> secretsQuestions;
	
	/**
	 * Constructeur d'un Credentials
	 * @param username Le nom d'utilisateur
	 * @param pwd Le mot de passe
	 */
	public Credentials(String username, String pwd) {
		this.id = compteur++;
		this.username = username;
		this.pwd = pwd;
	}

	/**
	 * Méthode d'accès au id du Credentials
	 * @return Le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Méthode d'accès au nom d'utilisateur
	 * @return le nom d'utilisateur
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Méthode qui permet de fixer le nom d'utilisateur
	 * @param username le nom d'utilisateur à`fixer
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Méthode d'accès au mot de passe
	 * @return Le mot de passe
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Méthode permettant de fixer le mot de passe.
	 * @param pwd Le mot de passe à fixer
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Méthode d'accès aux questions de sécurité
	 * @return Les questions en clé et les réponses en valeur
	 */
	public Map<String, String> getSecretsQuestions() {
		return secretsQuestions;
	}

	/**
	 * Méthode qui fixe les questions de sécurité
	 * @param secretsQuestions Le questions à fixer.
	 */
	public void setSecretsQuestions(Map<String, String> secretsQuestions) {
		this.secretsQuestions = secretsQuestions;
	}

	@Override
	public String toString() {
		return "Credentials [id=" + id + ", username=" + username + ", pwd=" + pwd + ", secretsQuestions="
				+ secretsQuestions + "]";
	}

	
	
}
