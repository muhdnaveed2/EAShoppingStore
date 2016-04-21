<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<%-- <script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
<form:form modelAttribute="productAdd" action= "addProduct" method="post" enctype="multipart/form-data">
        <h2>New Product</h2>
        <form:errors path="*" cssStyle="color : red;"  element="div"/>
        <table cellpadding="0" cellspacing="0" border="0" width="50%">         
	        <tr>
	        	<td>
		            <label for="firstName">Product Name: </label>
		        </td>
		        <td>
		            <form:input id="productName" path="name"/> 
	        	</td>
	        </tr>
	        <tr>
	        	<td>
	        		<label for="firstName">Product Brand: </label>
	        	<td>
		            <form:input id="productBrand" path="brandName"/> 
	        	</td>
        	</tr>
	        <tr>
	        	<td>
		            <label for="day">Product Stock: </label>
	            </td>
		        <td>
		            <form:input id="productStock" path="stock"/>  
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="day">Product Price: </label>
	            </td>
		        <td>
		            <form:input id="productPrice" path="price"/>  
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="type">Product Line: </label>
	            </td>
		        <td>
		            <form:input id="productLine" path="productLine"/>
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="type">Product Category: </label>
	            </td>
		        <td>
		            <form:input id="productCategory" path="productCategory"/>
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="type">Product Gender: </label>
	            </td>
		        <td>
		            <form:select id="genderLine" path="genderLine">
	                    <form:option value="0" label="Select One" selected="selected"/>
	                    <form:options items="${genderEnum }" />
	                </form:select>
		        </td>
	        </tr>
	        <tr>
	        	<td>
		            <label for="productImage">Upload Photo: </label>
	            </td>
		        <td>
		            <form:input id="productImage" path="productImage" type="file"/> 
		        </td>
	        </tr>
	        <tr id="buttons">
	         	<td>
	            	<input id="submit" type="submit" value="Register">
	        	</td>
	       	</tr>
        </table>
</form:form>
</body>
</html>