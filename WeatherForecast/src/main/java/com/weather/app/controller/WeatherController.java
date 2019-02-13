package com.weather.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.weather.app.impl.CallRestService;
import com.weather.app.validation.DateValidator;
import com.weather.app.validation.ZipcodeValidator;

@Controller
@RequestMapping("/getWeather")
public class WeatherController {
	
	@Autowired
	CallRestService callRestService;
	
	@Autowired
	DateValidator dateValidator; 
	
	@Autowired
	ZipcodeValidator zipcodeValidator;
	
	@RequestMapping("")
	public String getDisplay() {
		
		return "FirstPage";
	}
	
	@RequestMapping("/getWeatherDetails")
	public ModelAndView getWeatherDetails(@RequestParam("date") String date, @RequestParam("zipcode") String zipcode) {	
		
		ModelAndView mv = new ModelAndView();
		
		Boolean isDateCorrect = dateValidator.validate(date);

		Boolean isZipcodeCorrect = zipcodeValidator.validate(zipcode);
				
				
		if (isDateCorrect && isZipcodeCorrect) {
			
			Map<String, String> map =  callRestService.getResponse(date, zipcode);
			
			Map<String, String> map1 = callRestService.getCoolestHour(map);
			
			mv.setViewName("WeatherReportPage");
			mv.addObject("map", map);
			mv.addObject("coolestTemp", map1);
			mv.addObject("zipcode", zipcode);
		}
		
		else if (!isDateCorrect) {
			
			mv.setViewName("ErrorPage");
			mv.addObject("error", "Please enter date in correct format.");
		}
		
		else if (!isZipcodeCorrect) {
			
			mv.setViewName("ErrorPage");
			mv.addObject("error", "Please enter correct zipcode.");
		}
		
		return mv;
	
	}
	
}
