'use strict';
 
angular.module('myApp').controller('PokemonController', ['$scope', '$log', 'PokemonService', function($scope, $log, UserService) {
    var self = this;
    self.user={number:'',name:'',typeOne:'', typeTwo:'', total:'', hp:'', attack:'', defense:'', spattack:'', spdefense:'', speed:'', generation:'', legendary:''};
    self.pokemon=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllPokemon();
 
    function fetchAllPokemon(){
        PokemonService.fetchAllPokemon()
            .then(
            function(d) {
                self.pokemon = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
}]);