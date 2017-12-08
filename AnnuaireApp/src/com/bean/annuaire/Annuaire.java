package com.bean.annuaire;

/**
 * The Class Annuaire.
 */
public class Annuaire {

	private static volatile Annuaire instance;

	/**
	 * Constructuer privée pour le singleton.
	 */
	private Annuaire() {
	}

	/**
	 * Retourne une instance d'Annuaire.
	 *
	 * @return l'instance de l'annuaire
	 */
	public static Annuaire getInstance() {
		// Double lock for thread safety.
		if (instance == null) {
			synchronized (Annuaire.class) {
				if (instance == null) {
					instance = new Annuaire();
				}
			}
		}
		return instance;
	}
	
}
