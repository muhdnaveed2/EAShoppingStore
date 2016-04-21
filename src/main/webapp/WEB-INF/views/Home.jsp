<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Home</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<%-- <h1> ${greeting} </h1> --%>
			</div>	 
 
				  <div class="container">			 
 					 <%-- <a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a> --%> 
 					 
					 <a href="<spring:url value='/customer/addCustomer' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>Registration
					 </a>
					 
					 <a href="<spring:url value='/product/addProduct' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>Add Product
					 </a>
					 
					 <a href="<spring:url value='/product/showProducts' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>Show All Products
					 </a>
				</div>	
	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
		</div>	
	</section>
	
</body>
</html>
