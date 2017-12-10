package com.bean.compte;

public class Admin extends Client {
	
	private static final String PREFIXE = "a";
	
	private Credentials credentials;
	
	public Admin(String username, String password) {
		this.credentials = new Credentials(PREFIXE + username, password);
	}

	/**
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
