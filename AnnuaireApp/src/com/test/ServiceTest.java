package com.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bean.IBean;
import com.bean.contact.Particulier;
import com.service.Service;

public class ServiceTest {
	
	IBean b1, b2;
	Set<IBean> listeBean;

	@Before
	public void setUp() throws Exception {
		b1 = new Particulier("123", "patate", "chaloupe", "canape", "shibougamo");
		listeBean = new HashSet<IBean>();
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
		listeBean = null;
	}

	@Ignore
	public void testAddBean() {
		assertTrue(Service.addBean(b1, listeBean));
	}
	
	@Test
	public void testDeleteBean() {
		Service.addBean(b2, listeBean);
		assertTrue(Service.deleteBean(b2, listeBean));
	}

}
