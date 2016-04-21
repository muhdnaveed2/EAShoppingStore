<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie</title>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="0" width="50%">
		<tr>
			<td>Movie Name</td>
			<td>Releasing Year</td>
			<td>Genre</td>
		</tr>
		<c:forEach items="${movies }" var="movie">
        	<td>${movie.name }</td>
        	<td>${movie.releaseYear }</td>
        	<td>
        		<c:forEach items="${movie.genres }" var="genre">
        			<c:out value="${genre }" />
        			<c:out value=", " />
        		</c:forEach>
        	</td>
        </c:forEach>
	</table>
</body>
</html>