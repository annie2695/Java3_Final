package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LireCompteurProperties {
	
	public final static String PATH_PROPS = "C:/java3/tpFinal_max_annie/properties/compteur.properties";
	
	private static Logger logger = LogManager.getLogger(LireCompteurProperties.class);

	public static Properties getCompteurProperties(){
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(PATH_PROPS));
			
		} 
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return props;
		
	}

	public static int getCompteur(String bean){
		int compteur = -1;
		int nouveauCompteur = -1;
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(PATH_PROPS));
			switch (bean) {
				case "compte":
						compteur = Integer.parseInt(props.getProperty("compteurCompte"));
						nouveauCompteur = compteur;
						compteur++;
						props.setProperty("compteurCompte", String.valueOf(compteur));
						break;
				case "credentials":
						compteur = Integer.parseInt(props.getProperty("compteurCredentials"));
						nouveauCompteur = compteur;
						compteur++;
						props.setProperty("compteurCredentials", String.valueOf(compteur));
						break;
				case "adressBook":
						compteur = Integer.parseInt(props.getProperty("compteurAdressBook"));
						nouveauCompteur = compteur;
						compteur++;
						props.setProperty("compteurAdressBook", String.valueOf(compteur));
						break;
				case "contact":
						compteur = Integer.parseInt(props.getProperty("compteurContact"));
						nouveauCompteur = compteur;
						compteur++;
						props.setProperty("compteurContact", String.valueOf(compteur));
						break;
				case "address":
						compteur = Integer.parseInt(props.getProperty("compteurAddress"));
						nouveauCompteur = compteur;
						compteur++;
						props.setProperty("compteurAddress", String.valueOf(compteur));
						break;
				default:
					break;
			}
			File file = new File(PATH_PROPS);
			FileOutputStream fileOut = new FileOutputStream(file);
			props.store(fileOut, "Ce fichier contient les compteurs pour les objets associes.");
			fileOut.close();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}		
		return nouveauCompteur;
	}

	
}
