'use strict';
 
angular.module('myApp').controller('PokedexController', ['$scope', '$log', 'PokedexService', function($scope, $log, PokedexService) {
    var self = this;
    self.pokedex={id:null,name:'',game:'',regionality:'',shiny:'',puser:''};
    self.pokedexes=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllPokedexes();
 
    function fetchAllPokedexesByUsername(){
        PokedexService.fetchAllPokedexesByUsername(pokedex.puser)
            .then(
            function(p) {
                self.pokedexes = p;
            },
            function(errResponse){
                console.error('Error while fetching Pokedexes');
            }
        );
    }
 
    function createPokedex(pokedex){
        PokedexService.createPokedex(pokedex)
            .then(
            fetchAllPokedexes,
            function(errResponse){
                console.error('Error while creating Pokedex');
            }
        );
    }
	
	function getPokedexById(id) {
		PokedexService.getPokedexById(id)
			.then(
				fetchAllPokedexes,
				function(errResponse){
					console.error('Error while getting Pokedex');
				}
			)
	}
 
    function updatePokedex(user, id){
        PokedexService.updatePokedex(user, id)
            .then(
            fetchAllPokedexes,
            function(errResponse){
                console.error('Error while updating Pokedex');
            }
        );
    }
 
    function deletePokedex(id){
        PokedexService.deletePokedex(id)
            .then(
            fetchAllPokedexes,
            function(errResponse){
                console.error('Error while deleting Pokedex');
            }
        );
    }
 
    function submit() {
        if(self.user.id===null){
            console.log('Saving New Pokedex', self.pokedex);
            createPokedex(self.pokedex);
        }else{
            updatePokedex(self.pokedex, self.pokedex.id);
            console.log('Pokedex updated with id ', self.pokedex.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.pokedexes.length; i++){
            if(self.pokedexes[i].id === id) {
                self.pokedexes = angular.copy(self.pokedexes[i]);
                break;
            }
        }
    }

 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.pokedexes.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deletePokedex(id);
    }
 
 
    function reset(){
        self.pokedex={id:null,name:'',game:'',regionality:'',shiny:'',puser:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);