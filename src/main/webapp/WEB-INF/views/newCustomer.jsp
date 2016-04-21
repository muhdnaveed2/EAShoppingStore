<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
<div class="item-container" style="height:300px;">
<form:form modelAttribute="customerAdd" action= "addCustomer" method="post">
        <h2>Customer Registration</h2>
        <table cellpadding="0" cellspacing="0" border="0" width="50%">         
	        <tr>
	        	<td>
		            <label for="name">Full Name: </label>
		        </td>
		        <td>    
		            <form:input id="name" path="name"/>
		        	<form:errors path="name" cssStyle="color : red;" />  
	        	</td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="email">Email: </label>
	            </td>
		        <td>
		            <form:input id="email" path="email" />
					<form:errors path="email" cssStyle="color : red;" />
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="username">Username: </label>
	            </td>
		        <td>
		            <form:input id="username" path="credentials.username" />
					<form:errors path="credentials.username" cssStyle="color : red;" /> 
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="password">Password: </label>
	            </td>
		        <td>
		            <form:password id="password" path="credentials.password"/>
					<form:errors path="credentials.password" cssStyle="color : red;" /> 
		        </td>
	        </tr>
	        <tr>
	        	<td>
	            </td>
		        <td>
		            <form:hidden id="authorities" path="credentials.authority.authority" value="ROLE_USER"/>
					<%-- <form:errors path="email" cssStyle="color : red;" /> --%> 
		        </td>
	        </tr>
	        <tr id="buttons">
	         	<td>
	            	<input id="submit" type="submit" value="Register">
	        	</td>
	       	</tr>
        </table>
</form:form>
</div>
</body>
</html>