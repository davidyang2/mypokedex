'use strict';
 
angular.module('myApp').controller('UserController', ['$scope', '$log', 'UserService', function($scope, $log, UserService) {
    var self = this;
    self.user={id:null,username:'',email:'',password:'',switchfc:'',threedsfc:''};
	self.usersOne = {};
	self.usersTwo = {};
	try {
		self.usersOne = users.innerHTML.split("User");
		console.log("usersOne Array");
		console.log(self.usersOne);
	} catch (error) {
		console.log("ERROR");
	}
	
	for (let i = 1; i < self.usersOne.length; i++) {
			self.user = {};
			self.userOneSplit = self.usersOne[i].split(",");
			console.log("userOneSplit");
			console.log(self.userOneSplit);
			self.user.id = self.userOneSplit[0].substring(self.userOneSplit[0].lastIndexOf("=") + 1);
			self.user.username = self.userOneSplit[1].substring(self.userOneSplit[1].lastIndexOf("=") + 1);
			self.user.password = self.userOneSplit[2].substring(self.userOneSplit[2].lastIndexOf("=") + 1);
			self.user.email = self.userOneSplit[3].substring(self.userOneSplit[3].lastIndexOf("=") + 1);
			self.user.switchfc = self.userOneSplit[4].substring(self.userOneSplit[4].lastIndexOf("=") + 1);
			self.user.threedsfc = self.userOneSplit[5].substring(self.userOneSplit[5].lastIndexOf("=") + 1, self.userOneSplit[5].length - 1);
			console.log("self.user");
			console.log(self.user);
			self.usersTwo[i - 1] = self.user;
			console.log("self.usersTwo");
			console.log(self.usersTwo);
		}
	
    self.remove = remove;
    self.reset = reset;
 
    function fetchAllUsers(){
		console.log("fetching users");
        UserService.fetchAllUsers()
            .then(
            function(d) {
				console.log(d);
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
    function createUser(user){
		console.log("creating user");
        UserService.createUser(self.user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
	
	function getUserByUsername() {
		UserService.getUserByUsername(user.username)
			.then(
				fetchAllUsers,
				function(errResponse){
					console.error('Error while getting User');
				}
			)
	}
 
    self.updateUser = function(user, id){
		console.log("updating user", id);
		console.log(user);
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }
 
    self.deleteUser = function(id) {
		console.log("deleting user", id);
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
			$scope.$apply(),
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
		fetchAllUsers();
    }
 
    self.submit = function() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }

 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }
 
 
    function reset(){
        self.user={id:null,username:'',email:'', password:'', switchfc:'', threedsfc: ''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);