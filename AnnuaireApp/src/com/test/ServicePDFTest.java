package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.annuaire.Annuaire;
import com.bean.compte.User;
import com.service.ServicePDF;

public class ServicePDFTest {
	
	User u;
	
	@Before
	public void setUp() throws Exception {
		u = new User("LALA", "LALA");
		u.setEmail("lala@gmail.com");
		u.getAddressBook().setListeParticuliers(Annuaire.getInstance().getListeParticulier());
		u.getAddressBook().setListeEntreprises(Annuaire.getInstance().getListeEntreprise());
	}

	@After
	public void tearDown() throws Exception {
		u = null;
	}

	@Test
	public void testGenerePDF() {
		assertTrue(ServicePDF.generePDF(u));
	}

}
