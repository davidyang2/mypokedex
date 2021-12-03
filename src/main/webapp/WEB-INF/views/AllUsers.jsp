<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
        
    </style>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
 
 
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="UserController as ctrl">
    <h2>List of Users</h2>  
    <span style="display:none" id="users">${users}</span>
    <table class="table table-hover table-striped table-bordered">
        <tr>
            <td>ID</td><td>Username</td><td>Password</td><td>Email</td><td>Switch Friend Code</td><td>3DS Friend Code</td><td></td>
        </tr>
			<tr ng-repeat="u in ctrl.usersTwo">
				<td><span ng-bind="u.id"></span></td>
				<td><span ng-bind="u.username"></span></td>
				<td><span ng-show="!edit" ng-bind="u.password"></span><input ng-show="edit == true" ng-model="u.password"></input></td>
				<td><span ng-show="!edit" ng-bind="u.email"></span><input ng-show="edit == true" ng-model="u.email"></input></td>
				<td><span ng-show="!edit" ng-bind="u.switchfc"></span><input ng-show="edit == true" ng-model="u.switchfc"></input></td>
				<td><span ng-show="!edit" ng-bind="u.threedsfc"></span><input ng-show="edit == true" ng-model="u.threedsfc"></input></td>
				<td><span>
					<button type="button" ng-click="edit=true" ng-hide="edit==true"
						class="btn btn-primary custom-width" id="editUserButton">Edit</button>
					<button type="button" ng-click="ctrl.deleteUser(u.id)" ng-hide="edit==true"
						class="btn btn-warning custom-width" id="removeUserButton">Remove</button>
					<button type="button" ng-show="edit == true" ng-click="ctrl.updateUser(u, u.id); edit=false"
						class="btn btn-success custon-width" id="submitEditButton">Submit</button>
						</span>
				</td>
			</tr>
    </table>
    <br/>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
</body>
</html>