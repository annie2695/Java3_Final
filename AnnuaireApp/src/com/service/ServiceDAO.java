package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.IBean;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ServiceDAO {
	
	private static Logger LOGGER = LogManager.getLogger(ServiceDAO.class);

	public static boolean saveToXml(IBean bean, String path) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.alias("bean", IBean.class);
			stream.toXML(bean, new FileOutputStream(path+System.currentTimeMillis()+".xml"));
		} catch (Exception e) {
			LOGGER.info("Erreur d'�criture");
		}
		return new File(path).exists();
	}
	
	@SuppressWarnings("unchecked")
	public static Set<IBean> loadFromXml(String path) {
		Set<IBean> listeClients = null;
		try {
			if(new File(path).exists()){
				XStream stream = new XStream(new DomDriver());
				stream.alias("bean", IBean.class);
				listeClients =  (Set<IBean>) stream.fromXML(new FileInputStream(path));
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return listeClients;
	}

}
