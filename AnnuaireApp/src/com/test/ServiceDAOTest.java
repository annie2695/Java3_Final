package com.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bean.IBean;
import com.bean.compte.Admin;
import com.bean.compte.User;
import com.bean.contact.Entreprise;
import com.bean.contact.Particulier;
import com.service.ServiceDAO;

public class ServiceDAOTest {

	IBean b1, b2, b3, b4, b5, b6;
	//Set<IBean> listeBean;
	Set<IBean> listeAdmin, listeUser;
	String pathAdmin, pathUser;
	
	@Before
	public void setUp() throws Exception {
		/*b1 = new Entreprise("123", "patateDouce", "Friterie", "La-bas", "null part");
		((Entreprise)b1).setNom("Potatos 911");
		((Entreprise)b1).setTelephone("(514)999-0999");
		((Entreprise)b1).setCourriel("potatos911@gmail.com");
		b2 = new Particulier("456", "totoStreet", "totoCity", "TOT OTO", "TOTO Village");
		((Particulier)b2).setNom("Toto");((Particulier)b2).setPrenom("Toto");
		((Particulier)b2).setTelephone("(514)639-4242");
		((Particulier)b2).setCourriel("toto@gmail.com");
		b3 = new Particulier("789", "tataStreet", "tataCity", "TAT ATA", "TATA Village");
		((Particulier)b3).setNom("Tata");((Particulier)b3).setPrenom("Tata");
		((Particulier)b3).setTelephone("(450)634-7070");
		((Particulier)b3).setCourriel("tata@gmail.com");
		b4 = new Entreprise("7534", "sleepStreet", "Silence", "Z1Z 1Z1", "null part");
		((Entreprise)b4).setNom("Sommeil City");
		((Entreprise)b4).setTelephone("(514)555-5555");
		((Entreprise)b4).setCourriel("sommeil.city@gmail.com");
		b5 = new Particulier("951", "titiStreet", "titiCity", "TIT ITI", "TITI Village");
		((Particulier)b5).setNom("Titi");((Particulier)b5).setPrenom("Titi");
		((Particulier)b5).setTelephone("(514)894-1234");
		((Particulier)b5).setCourriel("titi@gmail.com");
		b6 = new Entreprise("4657", "GeekStreet", "InfoCity", "I0I 0I0", "null part");
		((Entreprise)b6).setNom("Geek - laptop");
		((Entreprise)b6).setTelephone("(450)654-9494");
		((Entreprise)b6).setCourriel("geek.laptop@gmail.com");
		
		
		listeBean = new HashSet<IBean>();
		listeBean.add(b1);listeBean.add(b2);listeBean.add(b3);
		listeBean.add(b4);listeBean.add(b5);listeBean.add(b6);
		
		path = "C:/java3/tpFinal_max_annie/sauvegarde/Annuaire.xml";*/
		
		b1 = new Admin("reda", "reda");
		b2 = new Admin("max", "max");
		b3 = new Admin("annie", "annie");
		
		b4 = new User("koko", "koko");
		((User)b4).setEmail("koko@gmail.com");
		
		b5 = new User("kaka", "kaka");
		((User)b4).setEmail("kaka@gmail.com");
		
		b6 = new User("kiki", "kiki");
		((User)b4).setEmail("kiki@gmail.com");
		
		listeAdmin = new HashSet<>();
		listeUser= new HashSet<>();
		
		listeAdmin.add(b1);listeAdmin.add(b2);listeAdmin.add(b3);
		listeUser.add(b4);listeUser.add(b5);listeUser.add(b6);
		
		pathAdmin = "C:/java3/tpFinal_max_annie/sauvegarde/admin.xml";
		pathUser = "C:/java3/tpFinal_max_annie/sauvegarde/user.xml";
		
		ServiceDAO.saveToXml(listeAdmin, pathAdmin);
	}

	@After
	public void tearDown() throws Exception {
		b1 = null; b2=null; b3=null;
		b4 = null; b5=null; b6=null;
		//listeBean =null;
		listeAdmin=null; listeUser=null;
		pathAdmin = null;pathUser = null;
	}

	@Test
	public void testSaveToXml() {
		assertTrue(ServiceDAO.saveToXml(listeUser, pathUser));
	}

	@Ignore
	public void testLoadFromXml() {
		assertNotNull(ServiceDAO.loadFromXml(pathAdmin));
	}

}
