package com.bean.addressbook;

import java.util.Set;
import java.util.TreeSet;

import com.bean.IBean;
import com.bean.contact.Contact;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 *
 * Repr�sente le carnet d'adresse d'un user.
 */
public class AddressBook implements IBean {

	private static int compteur =1;
	private int id;
	
	private Set<Contact> favoris;
	private Set<Contact> listeContacts;
	
	/**
	 * Constructeur de la classe.
	 */
	public AddressBook() {
		this.id = compteur;
		compteur++;
		
		favoris = new TreeSet<Contact>();
		listeContacts = new TreeSet<Contact>();
	}

	/**
	 * M�thode d'acc�s au id du carnet d'adresse
	 * @return Le id
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�thode d'acc�s � la liste des favoris
	 * @return La liste des favoris
	 */
	public Set<Contact> getFavoris() {
		return favoris;
	}

	/**
	 * M�thode d'acc�s � la liste des contacts
	 * @return La liste des contacts
	 */
	public Set<Contact> getListeContacts() {
		return listeContacts;
	}

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", favoris=" + favoris + ", listeContacts=" + listeContacts + "]";
	}
	
}
