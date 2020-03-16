<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>

<body>
	<div class="container">
		<h2>Search Your Flights Here</h2>
		<form:form class="form-horizontal"
			modelAttribute="flightSearchParameter" action="/flight/search">
			<div class="form-group">
				<label class="control-label col-sm-2" for="departureLocation">DepartureLocation:</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="departureLocation">
						<c:forEach var="departureLocation" items="${ departureLocation }"
							varStatus="loop">
							<form:option value="${departureLocation}">${departureLocation}</form:option>

						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Arrival Location:</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="arrivalLocation">
						<c:forEach var="arrivalLocation" items="${ arrivalLocation }"
							varStatus="loop">
							<form:option value="${arrivalLocation}">${arrivalLocation}</form:option>

						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Date Of Journey:</label>
				<div class="col-sm-10">
					<form:input type="date" class="form-control"
						placeholder="Enter Date Of Journey " path="date" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2">Select Flight Class:</label>
				<div class="col-sm-10">
					<form:select type="text" class="form-control" path="flightClass">
						<form:option value="">Select Flight Class</form:option>
						<form:option value="E">Economic Class</form:option>
						<form:option value="B">Business Class</form:option>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Search Preference:</label>
				<div class="col-sm-10">
					<form:select type="text" class="form-control"
						path="outputPreference">
						<form:option value="">Select Search Preference</form:option>
						<form:option value="fareSort">Fare</form:option>
						<form:option value="fareAndFlightDurationSort">Fare And Duration</form:option>
					</form:select>
				</div>
			</div>




			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>