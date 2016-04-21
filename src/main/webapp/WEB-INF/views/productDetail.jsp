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
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U-Store</title>
</head>
<body>
<form:form modelAttribute="cartAdd" action= "addToCart" method="post">
	<div class="item-container" style="height:500px;" >
		<div class="image-container" style="width:300px;float:left;">
            <img src='../resources/images/${product.name }.jpg' height="300px" width="300px" />
		</div>
		<div class="text-container" style="width:200px;float:left;">
			<div class="link-container" style="width:200px;float:left;">
				<b><c:out value="${product.name }"/></b> <br/>
				for <b><c:out value="${product.genderLine }"/></b>
			</div>
			<div class="brand-container" style="width:200px;float:left;">
				by <c:out value="${product.brandName }" />
			</div>
			<div class="price-container" style="width:200px;float:left;">
				Price: <b>$<c:out value="${product.price }" /></b>
			</div>
			<div class="price-container" style="width:200px;float:left;">
				In Stock: <b>$<c:out value="${product.stock }" /></b>
			</div>
			<div class="price-container" style="width:200px;float:left;">
				Category: <b>$<c:out value="${product.productCategory }" /></b>
			</div>
		</div>
		<div class="checkout-container" style="width:200px;float:left;">
			<%-- <form:hidden id="product_id" value="${product.id }" /> --%>
			<%-- <form:hidden id="product_id" value="${product.id }" path="productid" /> --%>
			<input class="btn btn-lg btn-success btn-mini" type="submit" value="Add to Cart" />	
		</div>
	</div>
</form:form>
</body>
</html>