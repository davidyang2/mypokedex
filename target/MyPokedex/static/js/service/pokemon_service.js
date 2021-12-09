'use strict';
 
angular.module('myApp').factory('PokemonService', ['$http', '$q', function($http, $q){
	
	var REST_SERVICE_URI = 'http://localhost:8080/MyPokedex/pokemon';
	
    var factory = {
        fetchAllPokemon: fetchAllPokemon,
    };
 
    return factory;
 
    function fetchAllPokemon() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while fetching Pokemon');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);