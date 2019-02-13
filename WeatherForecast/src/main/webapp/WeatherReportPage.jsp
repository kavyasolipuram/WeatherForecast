<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather Forecast</title>
<style>
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
	h2 {
	color: blue;
}
</style>
</head>
<br><br><br><br><br>
<body>
	<h2> Hourly Weather Forecast For Zipcode ${zipcode}</h2> <br><br>	

   <table style="width: 100%;">
   		<tr>
   			<th>Time</th>
	   		<c:forEach var="entry" items="${map}">  
	   			<td>${entry.key}</td>
	   		</c:forEach>
	    </tr>
		<tr>
			<th>Temperature</th>
	   		<c:forEach var="entry" items="${map}">  
	   			<td>${entry.value}</td>
	   		</c:forEach>
	    </tr>
   </table>
   <br>
   <br>
   <table>
  		<tr>
  			<th>Coolest hour(s)</th>
   		<c:forEach var="entry" items="${coolestTemp}">  
   			<td>${entry.key}</td>
   		</c:forEach>
    </tr>
	<tr>
		<th>Temperature</th>
   		<c:forEach var="entry" items="${coolestTemp}">  
   			<td>${entry.value}</td>
   		</c:forEach>
    </tr>
   </table>
</body>
</html>