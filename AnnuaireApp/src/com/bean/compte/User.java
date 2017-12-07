package com.bean.compte;

import com.bean.addressbook.AddressBook;

public class User extends Client {
	
	private static final String PREFIXE = "u";

	private AddressBook addressBook;
	
	public User() {
		super();
		addressBook = new AddressBook();
	}

	/**
	 * Méthode d'accès au carnet d'adresse.
	 * @return Le carnet d'adresse
	 */
	public AddressBook getAddressBook() {
		return addressBook;
	}
	
}
