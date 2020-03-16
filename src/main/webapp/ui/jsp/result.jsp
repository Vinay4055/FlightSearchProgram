<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Results</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
  <h2>Flight Results</h2>
  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Flight Number</th>
        <th>Flight Time</th>
        <th>Fare </th>
        <th>Flight Duration </th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="searchedResults" items="${searchedFlights }">
      <tr>
        <td>${searchedResults.flightNumber }</td>
        <td>${searchedResults.flightLocalTime }</td>
        <td>${searchedResults.fare } Rs</td>
        <td>${searchedResults.flightDuration } Hr</td>
      </tr>
      </c:forEach>
      </tbody>
      </table>
      </div>
</body>
</html>