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
import com.service.Service;

public class ServiceTest {
	
	IBean b1, b2;
	Set<IBean> listeBean;

	@Before
	public void setUp() throws Exception {
		b1 = new User("toto", "ytrewq");
		b2 = new Admin("tata", "ytrewq");
		listeBean = new HashSet<IBean>();
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
		b2 = null;
		listeBean = null;
	}

	@Ignore
	public void testAddBean() {
		assertTrue(Service.addBean(b1, listeBean));
	}

	@Ignore
	public void testDeleteBean() {
		Service.addBean(b2, listeBean);
		assertTrue(Service.deleteBean(b2, listeBean));
	}

	@Ignore
	public void testGetByid() {
		Service.addBean(b1, listeBean);
		Service.addBean(b2, listeBean);
		assertSame(b2, Service.getByid(b2.getId(), listeBean));
	}

	@Test
	public void testUpdateBean() {
		Service.addBean(b2, listeBean);
		
		assertTrue(Service.updateBean(b2, listeBean));
	}

}
