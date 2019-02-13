package com.weather.app.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.weather.app.validation.DateValidator;

public class DateValidatorTest {

	private DateValidator dateValidator;
	
	@Before
	public void init() {
		dateValidator = new DateValidator();		
	}
	
	@Test
	public void testDateIsTodayIsEmpty() {
		assertTrue(dateValidator.validate(""));
	}
	
	@Test
	public void testDateIsToday() {
		assertTrue(dateValidator.validate("today"));
	}

	@Test
	public void testDayIsTomorrow() {
		assertTrue(dateValidator.validate("TOMORROW"));
	}

	@Test
	public void testMonthIsInvalid() {
		assertFalse(dateValidator.validate("null"));
	}
	
	//Date format yyyy-MM-dd
	
	@Test
	public void testMonthInRightFormat() {
		assertTrue(dateValidator.validate("2019-02-10"));
	}

	@Test
	public void testYearInWrongFormat() {
		assertFalse(dateValidator.validate("31/20/1991"));
	}

}
