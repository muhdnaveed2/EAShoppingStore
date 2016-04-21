<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<security:authorize access="isAnonymous()">
<li><a href="<spring:url value="/login"/>">Login</a></li>
<li><a href="<spring:url value="/product/checkout"/>">Checkout</a></li>
</security:authorize>

<security:authorize access="isAuthenticated()">
<li>Welcome <b><security:authentication property="principal.username" /></b></li>
<li><a href="<spring:url value="/j_spring_security_logout"/>">Logout</a></li>
<li><a href="<spring:url value="/product/checkout"/>">Checkout</a></li>
</security:authorize>

<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<spring:url value="/product/addProduct"/>">Add Product</a></li>
</security:authorize>