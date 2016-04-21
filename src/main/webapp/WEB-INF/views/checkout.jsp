<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="src/main/webapp/resources/css/collapsiblePanel.css" />
<link type="text/css" rel="stylesheet"
	href="src/main/webapp/resources/css/checkout.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U-Store Checkout</title>
<script>
	//$(document).ready(function()){

	// }
</script>
</head>
<body>
<div style="height:300px;">
	<form:form modelAttribute="shoppingOrder" action="checkout" method="post">

		<table>
		
			<tr>
			
				<td>
					
					<h3 style="color: #c45500 !important">1. Choose a shipping
					
					address</h3>
				
				</td>
			
			</tr>
			
			<c:if test="${!empty address}">
			
				<tr>
				
					<td>${address.houseno} ${address.street}, ${address.city}, ${address.state} - ${address.zip}</td>
				
				</tr>
				
				</c:if>
			
			<tr>
			
				<td><a href="<spring:url value='/product/addShippingAddress' />">
				
					Add New Address </a></td>
				
				<td><h3 style="font-weight: 700 !important;">Order Summary</h3></td>
			
			</tr>
			
			<tr>
			
				<td><h3 style="color: #c45500 !important">2. Choose a
				
					payment method</h3></td>
				
				<td>Items:</td>
				
				<td>${items}</td>
			
			</tr>
			
			<tr>
			
				<td><span style="font-weight: 700 !important"> Your
				
					credit and debit cards </span></td>
				
				<td>Total Price:</td>
				
				<td>${totalPrice}</td>
			
			</tr>
			<c:if test="${!empty billingInfo}">
			
				<tr>
				
					<td>${billingInfo.cardName}</td>
				
				</tr>
				
				</c:if>
			<tr>
				<td>
					<a href="<spring:url value='/product/addBillingInfo' />"> Add
								Billing Information </a>
				</td>
			</tr>
		
			<tr id="buttons">
				<td>
				</td>
	         	<td>
	            	<input id="submit" type="submit" value="Checkout">
	        	</td>
	       	</tr>
		</table>
	
	</form:form>
</div>
</body>
</html>
