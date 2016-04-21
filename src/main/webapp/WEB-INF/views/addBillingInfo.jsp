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
<title>Add Billing Information</title>
</head>
<body>
	<c:if test="${!empty message}">
		<div style="color : red;">
			${message}
		</div>
	</c:if>
	<form:form modelAttribute="billingInfoAdd"
		action="addBillingInfo" method="post">
		<h2>New Billing Information</h2>
		<form:errors path="*" cssStyle="color : red;" element="div" />
		<table cellpadding="0" cellspacing="0" border="0" width="50%">
			<tr>
				<td><label for="cardName">Name on Card: </label></td>
				<td><form:input id="nameOnCards" path="cardName" /></td>
			</tr>
			<tr>
				<td><label for="cardType">Card Type: </label></td>
				<td><form:input id="typeOfTheCard" path="cardType" /></td>
			</tr>
			<tr>
				<td><label for="cardNumber">Card Number: </label></td>
				<td><form:input id="cardNo" path="cardNumber" /></td>
			</tr>
			<tr>
				<td><label for="cardExpiry">Card Expiry: </label>
				<td><form:input id="cardExpiryDate" path="cardExpiry" /></td>
			</tr>

			<tr>
				<td><label for="cardPin">Card Pin: </label></td>
				<td><form:input id="cardPinNo" path="cardPin" /></td>
			</tr>
			<tr id="buttons">
				<td></td>
				<td><input id="submit" type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>