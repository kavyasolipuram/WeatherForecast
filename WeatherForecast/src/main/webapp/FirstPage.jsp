<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Weather Forecast</title>
<style>
	h2 {
		color: blue;
	}
</style>
</head>
<body>
	<form action="/getWeather/getWeatherDetails">
		<h2>Hourly Weather Forecast</h2> <br>
		<b>Enter 5-digit zipcode*: <input type="text" name="zipcode" required> </b><br><br>
		Date: <input type="text" name="date" value="tomorrow"> <br>
	    (Date format: today, tomorrow or yyyy-MM-dd) <br><br>
		<input type="Submit"> <br><br>
		<small>*Required</small>
	</form>
</body>
</html>