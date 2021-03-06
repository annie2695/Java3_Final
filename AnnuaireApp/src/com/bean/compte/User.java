package com.bean.compte;

import com.bean.addressbook.AddressBook;

public class User extends Compte {
	
	private static final String PREFIXE = "u";
	private AddressBook addressBook;
	
	private Credentials credentials;
	
	public User(String username, String password) {
		super();
		this.setCredentials(new Credentials(PREFIXE + username, password));
		this.addressBook = new AddressBook();
		this.addressBook.setUser(this);
	}

	/**
	 * Methode d'acces au carnet d'adresse.
	 * @return Le carnet d'adresse
	 */
	public AddressBook getAddressBook() {
		return addressBook;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

	
	
	
}
