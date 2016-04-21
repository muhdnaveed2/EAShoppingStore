<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>

<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
</head>
<body>
<style type="text/css">

 ul,li { list-style-type: none;
        list-style-position:inside;
        margin:0;
        padding:5px; }
</style>
 	<div align='left'>
		<table cellspacing="0" cellpadding="0" border="0">
			<tr >
 				<td width="25%" style="vertical-align:top;">
					<h3><tiles:insertAttribute name="left-nav-tile"/></h3>
				</td>
 				<td width="75%" >
					<div class="jumbotron">
						<h1 align='center'><tiles:insertAttribute name="head-tile"/></h1>
					</div>
					<tiles:insertAttribute name="body-tile"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="footer">
						<tiles:insertAttribute name="foot-tile"/>
					</div>		
				</td>
			</tr>
		</table>
    </div>
</body>
</html>