package com.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bean.IBean;
import com.bean.contact.Entreprise;
import com.bean.contact.Particulier;
import com.service.ServiceDAO;

public class ServiceDAOTest {

	IBean b1, b2, b3;
	Set<IBean> listeBean;
	String path;
	
	@Before
	public void setUp() throws Exception {
		b1 = new Entreprise("123", "patateDouce", "Friterie", "La-bas", "null part");
		b2 = new Particulier("456", "totoStreet", "totoCity", "TOT OTO", "TOTO Village");
		b3 = new Particulier("789", "tataStreet", "tataCity", "TAT ATA", "TATA Village");
		
		listeBean = new HashSet<IBean>();
		listeBean.add(b1);listeBean.add(b2);listeBean.add(b3);
		
		path = "C:/java3/tpFinal_max_annie/sauvegarde/Contact/Test01.xml";
	}

	@After
	public void tearDown() throws Exception {
		b1 = null; b2=null; b3=null;
		listeBean =null;
		path = null;
	}

	@Test
	public void testSaveToXml() {
		assertTrue(ServiceDAO.saveToXml(listeBean, path));
	}

	@Test
	public void testLoadFromXml() {
		assertNotNull(ServiceDAO.loadFromXml(path));
	}

}
