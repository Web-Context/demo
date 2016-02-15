'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostviewctrlCtrl
 * @description
 * # PostviewctrlCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
 .controller('PostViewCtrl', ['$scope', '$routeParams','$http',
 	function($scope, $routeParams,$http) {
 		var id = parseInt($routeParams.id);
 		$http.get('rest/posts.json').success(function(data) {
 			for (var i = 0; i < data.length; i++) {
 				if(data[i].id==id){
 					$scope.post = data;
 					break;
 				}
 			}
 		});
 	}]);
