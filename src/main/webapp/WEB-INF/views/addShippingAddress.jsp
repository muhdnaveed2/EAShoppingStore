<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<%-- <script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Shipping Address</title>
</head>
<body>
	<form:form modelAttribute="shippingAddressAdd"
		action="addShippingAddress" method="post">
		<h2>New Shipping Address</h2>
		<form:errors path="*" cssStyle="color : red;" element="div" />
		<table cellpadding="0" cellspacing="0" border="0" width="50%">
			<tr>
				<td><label for="houseno">House No: </label></td>
				<td><form:input id="houseNum" path="houseno" /></td>
			</tr>
			<tr>
				<td><label for="street">Street: </label></td>
				<td><form:input id="streetName" path="street" /></td>
			</tr>
			<tr>
				<td><label for="city">City: </label>
				<td><form:input id="cityName" path="city" /></td>
			</tr>

			<tr>
				<td><label for="state">State: </label></td>
				<td><form:input id="stateName" path="state" /></td>
			</tr>
			<tr>
				<td><label for="zip">Zip: </label></td>
				<td><form:input id="zipNo" path="zip" /></td>
			</tr>
			<tr id="buttons">
				<td></td>
				<td><input id="submit" type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>