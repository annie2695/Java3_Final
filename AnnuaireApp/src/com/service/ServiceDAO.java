package com.service;

import java.io.File;
import java.io.FileOutputStream;
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
			LOGGER.info("Erreur d'écriture");
		}
		return new File(path).exists();
	}
	
	public static Set<IBean> loadFromXml() {
		return null;
	}

}
