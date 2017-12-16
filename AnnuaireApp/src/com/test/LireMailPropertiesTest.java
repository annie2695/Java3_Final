package com.test;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.service.LireMailProperties;


public class LireMailPropertiesTest {
	
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
	public void testGetMailProperties() {
		assertTrue(LireMailProperties.getMailProperties() == props);
	}

}
