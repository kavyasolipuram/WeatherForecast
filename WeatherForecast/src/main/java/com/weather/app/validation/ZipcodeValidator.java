package com.weather.app.validation;

import org.springframework.stereotype.Component;

@Component
public class ZipcodeValidator implements Validator{
		
	public boolean validate (String value) {
				
		if (value.length() == 5) {
			
			for (char c : value.toCharArray())
		    {
		        if (!Character.isDigit(c)) 
		        	return false;
		    }
		    return true;
		}
		return false;
	}
}
