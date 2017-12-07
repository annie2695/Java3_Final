package com.bean.compte;

import com.bean.addressbook.AddressBook;

public class User extends Client {

	private static final String PREFIXE = "u";
	private AddressBook addressBook;
	
	private Credentials credential;
	
	public User(String username, String password) {
		super();
		this.credential = new Credentials(PREFIXE + username, password);
		this.addressBook.setUser(this);
	}

	/**
	 * Méthode d'accès au carnet d'adresse.
	 * @return Le carnet d'adresse
	 */
	public AddressBook getAddressBook() {
		return addressBook;
	}
	
}
