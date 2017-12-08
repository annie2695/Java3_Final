package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.IBean;
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

}
