package com.weather.app.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component
public class CallRestService {
	
	
	String url1 = "http://api.worldweatheronline.com/premium/v1/weather.ashx?";

	String key = "2ab36c70f79141d4a9014926190902";
	
	// time interval set to 1 hour
	String tp = "1";
	
	String format = "json";
	
	public Map<String, String> getResponse(String date, String zipcode) {
		
		Integer time = 0;
		String tempF = null;
		Map<String,String> map = new LinkedHashMap<>();
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			Gson gson = new Gson();
			
			String url = url1 + "key=" + key + "&format=" + format + "&date=" + date + "&q=" + zipcode + "&tp=" + tp;
	
			String jsonInString =  restTemplate.getForObject(url, String.class);
			
			JsonElement element = gson.fromJson(jsonInString, JsonElement.class);
			JsonObject jsonObj = element.getAsJsonObject();
			JsonArray weatherArray = jsonObj.get("data").getAsJsonObject().get("weather").getAsJsonArray();
			for (JsonElement obj : weatherArray) {
			    JsonObject weatherObj = obj.getAsJsonObject();
			    JsonArray hourlyArray = weatherObj.get("hourly").getAsJsonArray();
			    for(JsonElement hourlyelement : hourlyArray) {
			    	JsonObject hourlyObj = hourlyelement.getAsJsonObject();
			    	time = hourlyObj.get("time").getAsInt();
			    	tempF = hourlyObj.get("tempF").getAsString();
			    	if (time == 0)
			    		map.put("12 AM", tempF + " F");
			    	else if (time > 0 && time < 1200) {
			    		time = time / 100;
			    		map.put(time.toString() + " AM", tempF + " F");
			    	}
			    	else if (time == 1200) {
			    		map.put("12 PM", tempF + " F");
			    	}
			    	else if (time > 1200 && time < 2400) {
			    		time = (time / 100) % 12;
			    		map.put(time.toString() + " PM", tempF + " F");
			    	}		    	
			    }
			}
		} catch (Exception e) { 
			e.getMessage();
		}
			
		return map;
		
	}
	
	public Map<String, String> getCoolestHour(Map<String, String> map) {
		
		Map<String, String> hashmap = new HashMap<>();
		Set<String> keys = map.keySet();
		String coolestTemp = Collections.min(map.values());
		
		for (String key : keys) {
			
			if (map.get(key).equals(coolestTemp)) {
				hashmap.put(key, coolestTemp);
			}
		}		
		return hashmap;
	}
}
