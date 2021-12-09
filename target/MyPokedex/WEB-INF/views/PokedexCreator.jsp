<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Create a New Pokedex</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
 
    </style>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
     	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="PokedexController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Log In</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="name">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.pokedex.name" id="name" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="0"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.name.$error.required">This is a required field</span>
                                      <span ng-show="myForm.name.$error.minlength">Minimum length required is 0</span>
                                      <span ng-show="myForm.name.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                     	 <label class="col-md-2 control-lable" for="name">Region</label>
                      		<select class="form-select" ng-model="ctrl.pokedex.region" aria-label="Default select example">
  								<option selected>Galar</option>
  								<option value="2">Alola</option>
  								<option value="3">Kalos</option>
  								<option value="4">Unova</option>
  								<option value="5">Sinnoh</option>
  								<option value="6">Hoenn</option>
  								<option value="6">Johto</option>
  								<option value="6">Kanto</option>
  								
					  		</select>
					  </div>
					  
					  <div class="row">
					  <label class="col-md-2 control-lable" for="name">Regionality</label>
					  	<div class="form-check">
  							<input class="form-check-input" type="radio" ng-model="ctrl.pokedex.regionality" ng-value="false" name="flexRadioDefault1" id="flexRadioDefault1">
  								<label class="form-check-label" for="flexRadioDefault1">
    							National
  								</label>
						</div>
						<div class="form-check">
  							<input class="form-check-input" type="radio" ng-model="ctrl.pokedex.regionality" ng-value="true" name="flexRadioDefault1" id="flexRadioDefault1" checked>
  								<label class="form-check-label" for="flexRadioDefault1">
    							Regional
  								</label>
						</div>
					  </div>
					  
					  <div class="row">
					  <label class="col-md-2 control-lable" for="name">Type</label>
					  	<div class="form-check">
  							<input class="form-check-input" type="radio" ng-model="ctrl.pokedex.shiny" ng-value="false" name="flexRadioDefault2" id="flexRadioDefault2">
  								<label class="form-check-label" for="flexRadioDefault2">
    							Normal
  								</label>
						</div>
						<div class="form-check">
  							<input class="form-check-input" type="radio" ng-model="ctrl.pokedex.shiny" ng-value="true" name="flexRadioDefault2" id="flexRadioDefault2" checked>
  								<label class="form-check-label" for="flexRadioDefault2">
    							Shiny
  								</label>
						</div>
					  </div>
					
 
                      <div class="row">
                          <div class="form-actions floatRight">
                          	<a href="/MyPokedex/mypokedexhome/">
                          		<input type="button" value="Submit" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                          	</a>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
      </div>
      
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/pokedex_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/pokedex_controller.js' />"></script>
  </body>
</html>