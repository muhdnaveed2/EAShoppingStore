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
<title>U-Store</title>
</head>
<body>
	<!-- <div style="float:right"> -->
	<c:forEach var="product" items="${products }">
		<div class="item-container" style="height:300px;width:200px;float:left;cursor:pointer;" 
					id="result_${product.id }" onclick="location.href='../product/getProductDetail?product_id=${product.id }'" >
			<div class="image-container" style="width:200px;">
				<%-- <a href="${pageContext.request.contextPath}/download/${document.id}.html"><img
	                src="${pageContext.request.contextPath}/img/save_icon.gif" border="0"
	                title="Download this document"/></a> --%>
	                
	            <%-- <%byte[] encodeBase64 = Base64.encode(user.getProfile().getPhoto());
	            String base64Encoded = new String(encodeBase64, "UTF-8");
	            mav.addObject("userImage", base64Encoded ); %> --%>
	            <img src='../resources/images/${product.name }.jpg' height="200px" width="190px" />
			</div>
			<div class="text-container" style="width:200px;">
				<div class="link-container">
					<b><c:out value="${product.name }"/><br/></b>
					for <b><c:out value="${product.genderLine }"/></b>
				</div>
				<div class="brand-container" style="width:200px;">
					by <c:out value="${product.brandName }" />
				</div>
			</div>
			<div class="price-container" style="width:200px;">
				<b>$<c:out value="${product.price }" /></b>
			</div>
		</div>
	</c:forEach>
	<!-- </div> -->
</body>
</html>