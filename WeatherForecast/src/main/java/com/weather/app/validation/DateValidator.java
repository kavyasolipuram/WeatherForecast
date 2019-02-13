package com.weather.app.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DateValidator implements Validator{
	
	public boolean validate (String value) {
		
		if (value.isEmpty()) {
			value = "tomorrow";
			return true;
		}
				
		else if (value.equalsIgnoreCase("today") || value.equalsIgnoreCase("tomorrow"))
			return true;
		
		else {
					
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			
			try {
				
				//if not valid, it will throw Exception
				Date date = sdf.parse(value);
				System.out.println(date);
			
			} catch (Exception e) {
				
				e.getMessage();
				return false;
			}
			
			return true;
		}			
	}
	
}
