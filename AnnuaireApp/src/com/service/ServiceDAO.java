package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.IBean;
import com.bean.annuaire.Annuaire;
import com.bean.compte.Client;
import com.bean.compte.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ServiceDAO {
	
	private static Logger logger = LogManager.getLogger(ServiceDAO.class);

	public static boolean saveToXml(Set<IBean> listeBean, String path) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.alias("Liste", Set.class);
			
			stream.toXML(listeBean, new FileOutputStream(path));
		} catch (Exception e) {
			logger.error("Erreur d'écriture");
		}
		return new File(path).exists();
	}
	
	@SuppressWarnings("unchecked")
	public static Set<IBean> loadFromXml(String path) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.alias("Liste", Set.class);
			
			return (Set<IBean>) stream.fromXML(new FileInputStream(path));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	public static void sauvegarderUsernamePwdDansFichier(String username, String pwd, String path){
		try {
			String string = username + "|" + pwd;
			File file = new File(path);
			FileUtils.write(file, string, "UTF-8", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void readInFile(String path){
		try {
			String[] informations;
			List<String> stringFromFile = FileUtils.readLines(new File(path), "UTF-8");
			for (String string : stringFromFile) {
				informations = string.split("|");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		/*Set<IBean> listeBean = new HashSet<>();
		IBean user1 = new User("Patate", "102341");
		IBean user2 = new User("Goerge", "kiki");
		IBean user3 = new User("koko", "kiki");
		listeBean.add(user1);listeBean.add(user2);listeBean.add(user3);		
		saveToXml(listeBean, "H:/Programmation/git/Java3_Final/user.xml");*/
		
		Annuaire annuaire = Annuaire.getInstance();
		
		for (IBean user : annuaire.getInstance().getListeUser()) {
			System.out.println(((User) user).getCredentials().getUsername());
		}
		
		System.out.println(ServiceAuthentification.validateUser("koko", "kiki", annuaire.getListeUser()));
		
	}

}
