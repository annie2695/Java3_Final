package com.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.IBean;
import com.bean.compte.Admin;
import com.bean.compte.User;
import com.service.ServiceAuthentification;

public class ServiceAuthentificationTest {

	IBean u, a;
	Set<IBean> listeUser;
	Set<IBean> listeAdmin;
	String str1, str2;
	
	@Before
	public void setUp() throws Exception {
		u = new User("LALA", "LALA");
		a = new Admin("nini", "nini");
		listeUser = new HashSet<IBean>();
		listeUser.add(u);
		listeAdmin = new HashSet<IBean>();
		listeAdmin.add(a);
		str1 = "Allo"; str2=null;
	}

	@After
	public void tearDown() throws Exception {
		u = null;
		a = null;
		listeUser = null;
		listeAdmin = null;
		str1 = null; str2=null;
	}

	@Test
	public void testValidateUser() {
		assertSame(u.getId(), ServiceAuthentification.validateUser(((User)u).getCredentials().getUsername(),
				((User)u).getCredentials().getPwd(), listeUser));
	}

	@Test
	public void testValidateAdmin() {
		assertTrue(ServiceAuthentification.validateAdmin(((Admin)a).getCredentials().getUsername(), 
				((Admin)a).getCredentials().getPwd(), listeAdmin)==a.getId());
	}

	@Test
	public void testValiderMotDePasse() {
		assertNotSame(str1, str2);
	}

}
