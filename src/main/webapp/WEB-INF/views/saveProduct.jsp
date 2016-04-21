<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Added</title>
</head>
<body>
	<p>
		Product Added successfully to database with details: <br/> 		
		<b>Product Name:</b> ${product.name}	<br/>
		<b>Product Stock:</b> ${product.stock}	<br/>
		<b>Product Price:</b> ${product.price}	<br/>
		<b>Product Brand:</b> ${product.brandName}	<br/>
		<b>Product ProductLine:</b> ${product.productLine}	<br/>
		<b>Product ProductCategory:</b> ${product.productCategory} <br/>
		<br/>
		<%-- To: ${rootDirectory } --%>
	</p>
</body>
</html>