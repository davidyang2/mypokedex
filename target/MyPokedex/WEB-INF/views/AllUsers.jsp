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
				<td><span ng-bind="u.password"></span></td>
				<td><span ng-bind="u.email"></span></td>
				<td><span ng-bind="u.switchfc"></span></td>
				<td><span ng-bind="u.threedsfc"></span></td>
				<td><span>
					<button type="button" ng-click="ctrl.updateUser(u, u.id)"
						class="btn btn-primary custom-width" id="editUserButton">Edit</button>
					<button type="button" ng-click="ctrl.deleteUser(u.id)"
						class="btn btn-warning custom-width" id="removeUserButton">Remove</button></span>
				</td>
			</tr>
    </table>
    <
    <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal" ng-hide="editUserButton">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Username</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="password">Password</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.password" id="password" class="email form-control input-sm" placeholder="Enter your Password" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.password.$error.required">This is a required field</span>
                                      <span ng-show="myForm.password.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <%-- Add password confirmation field here--%>
                      
				   	  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="switchfc">Switch Friend Code [Optional]</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.switchfc" id="switchfc" class="switchfc form-control input-sm" placeholder="Enter your Switch Friend Code [SW-XXXX-XXXX-XXXX-XXXX]"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.switchfc.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="threedsfc">3DS Friend Code [Optional]</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.threedsfc" id="threedsfc" class="threedsfc form-control input-sm" placeholder="Enter your 3DS Friend Code [XXXX-XXXX-XXXX]"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.threedsfc.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                          		<input type="button" ng-click="ctrl.submit()" value="Submit" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
    <br/>
    <a href="<c:url value='/new' />">Add New Employee</a>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
</body>
</html>