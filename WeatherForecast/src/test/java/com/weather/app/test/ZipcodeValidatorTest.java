package com.weather.app.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.weather.app.validation.ZipcodeValidator;

public class ZipcodeValidatorTest {

	
	private ZipcodeValidator zipcodeValidator;
	
	@Before
	public void init() {
		zipcodeValidator = new ZipcodeValidator();		
	}
	
	@Test
	public void testZipcode1() {
		assertTrue(zipcodeValidator.validate("46032"));
	}

	@Test
	public void testZipcode2() {
		assertFalse(zipcodeValidator.validate("1234"));
	}

	@Test
	public void testZipcode3() {
		assertFalse(zipcodeValidator.validate("TESTS"));
	}
	
	@Test
	public void testZipcode4() {
		assertFalse(zipcodeValidator.validate("1TEST"));
	}

}
