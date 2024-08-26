package com.wynd.vop.person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonPropertiesTest {

	PersonProperties instance;

	private static final String SET_ENV = "Set Env";
	private static final String SET_PROPSOURCE = "Set PropSource";
	private static final String SET_SAMPLEPROPERTY = "Set SampleProperty";
	private static final String SET_PASSWORD = "Set Password";

	@Before
	public void setUp() {
		instance = new PersonProperties();
	}

	@Test
	public void testSetEnv() {
		String expResult = SET_ENV;
		instance.setEnv(expResult);
		String result = instance.getEnv();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetPropSource() {
		String expResult = SET_PROPSOURCE;
		instance.setPropSource(expResult);
		String result = instance.getPropSource();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetSampleProperty() {
		String expResult = SET_SAMPLEPROPERTY;
		instance.setSampleProperty(expResult);
		String result = instance.getSampleProperty();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetPassword() {
		String expResult = SET_PASSWORD;
		instance.setPassword(expResult);
		String result = instance.getPassword();
		assertEquals(expResult, result);
	}
}
