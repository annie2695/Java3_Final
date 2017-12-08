package com.bean.compte;

public class Admin extends Client {
	
	private static final String PREFIXE = "a";
	
	private Credentials credentials;
	
	public Admin(String username, String password) {
		this.credentials = new Credentials(PREFIXE + username, password);
	}

}
