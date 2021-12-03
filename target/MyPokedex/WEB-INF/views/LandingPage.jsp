<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Pokedex</title>
<style>
 
    </style>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></link>
     	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<h1>Welcome to MyPokedex!</h1><br>
	<h3>A Living Dex Pokemon Tracker</h2>
	<p>Support for all generations of mainline Pokemon games</h3><br>
	<a href="/MyPokedex/login">
  		<button type="button" class="btn btn-primary">Login</button>
	</a><br><br>
	<a href="/MyPokedex/signup">
  		<button type="button" class="btn btn-secondary">Sign Up</button>
	</a>
</body>
</html>