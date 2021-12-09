'use strict';
 
angular.module('myApp').factory('PokedexService', ['$http', '$q', function($http, $q){
	
	var REST_SERVICE_URI = 'http://localhost:8080/MyPokedex/pokedex';
	
    var factory = {
		fetchAllPokedexes: fetchAllPokedexes,
        fetchAllPokedexesByUsername: fetchAllPokedexesByUsername,
        createPokedex: createPokedex,
        updatePokedex: updatePokedex,
        deletePokedex: deletePokedex,
    };


    return factory;

    function fetchAllPokedexes() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while fetching Pokedexes');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchAllPokedexesByUsername(username) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+username)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while fetching Pokedexes with specified user');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
 
    function createPokedex(pokedex) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, pokedex)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while creating Pokedex');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updatePokedex(pokedex, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, pokedex)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while updating Pokedex');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deletePokedex(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while deleting Pokedex');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);