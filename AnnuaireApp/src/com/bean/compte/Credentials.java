package com.bean.compte;

import java.util.Map;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 * 
 * Classe donnant un nom d'utilisateur et un mot de passe
 * aux utilisateurs du syst�me.
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
	 * M�thode d'acc�s au id du Credentials
	 * @return Le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�thode d'acc�s au nom d'utilisateur
	 * @return le nom d'utilisateur
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * M�thode qui permet de fixer le nom d'utilisateur
	 * @param username le nom d'utilisateur �`fixer
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * M�thode d'acc�s au mot de passe
	 * @return Le mot de passe
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * M�thode permettant de fixer le mot de passe.
	 * @param pwd Le mot de passe � fixer
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * M�thode d'acc�s aux questions de s�curit�
	 * @return Les questions en cl� et les r�ponses en valeur
	 */
	public Map<String, String> getSecretsQuestions() {
		return secretsQuestions;
	}

	/**
	 * M�thode qui fixe les questions de s�curit�
	 * @param secretsQuestions Le questions � fixer.
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
