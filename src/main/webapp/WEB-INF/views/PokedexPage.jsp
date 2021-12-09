<%-- Consider using a tag --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pokedex List</title>
<style>
 
    </style>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></link>
     	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<h1>Pokedex List</h1><br>
	<div class="col text-center">
		<a href="/MyPokedex/mypokedex/create">
  			<button type="button" class="btn btn-primary">Create a New Pokedex</button>
		</a>
	</div>
</body>
</html>