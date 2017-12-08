package com.bean.compte;

import com.bean.addressbook.AddressBook;

public class User extends Client {
	
	private static final String PREFIXE = "u";
	private AddressBook addressBook;
	
	private Credentials credentials;
	
	public User(String username, String password) {
		super();
		this.credentials = new Credentials(PREFIXE + username, password);
		this.addressBook.setUser(this);
	}

	/**
	 * M�thode d'acc�s au carnet d'adresse.
	 * @return Le carnet d'adresse
	 */
	public AddressBook getAddressBook() {
		return addressBook;
	}
	
}
