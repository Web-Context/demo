'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostviewctrlCtrl
 * @description
 * # PostviewctrlCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
 .controller('PostViewCtrl', ['$scope', '$routeParams','$http','Post',
 	function($scope, $routeParams,$http,Post) {
 		var id = parseInt($routeParams.id);
 		$http.get('rest/posts.json').success(function(data) {
 			$scope.post = Post.findById(data,id);
 		});
 	}]);
