package com.test;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.service.LireCompteurProperties;

public class LireCompteurPropertiesTest {
	
	Properties props;

	@Before
	public void setUp() throws Exception {
		 props = new Properties();
	}

	@After
	public void tearDown() throws Exception {
		props = null;
	}

	@Test
	public void testGetCompteurProperties() {
		assertTrue(LireCompteurProperties.getCompteurProperties() == props);
	}

	@Test
	public void testGetCompteur() {
		assertTrue(LireCompteurProperties.getCompteur("user") >= 0);
	}

}
