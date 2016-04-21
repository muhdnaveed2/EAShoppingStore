<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Movie</title>
</head>
<body>

<form action="searchMovie" method="get">
		<!-- <fieldset> -->
		<h2>Search</h2>
		<table cellpadding="0" cellspacing="0" border="0" width="50%">
			<tr>
				<td><label for="search">Search </label></td>
				<td> <input id="searchText" /></td>
				<td> <select id="searchType" />
					 <option value="movie" label="Movie" selected="selected"/>
					 <option value="genre" label="Genre" />
					 <option value="actor" label="Actor" />
					 <option value="director" label="Director" />
					 <option value="year" label="Year" />
					 <option value="character" label="Character" />
					 <option value="rating" label="Rating" />
				</td>
			</tr>
		</table>
		<!-- </fieldset> -->
	</form>
</body>
</html>