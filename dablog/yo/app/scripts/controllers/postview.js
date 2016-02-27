'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostviewctrlCtrl
 * @description
 * # PostviewctrlCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
 .controller('PostViewCtrl', ['$scope', '$routeParams','$http','Post',
 	function($scope, $routeParams,$http,Post) {
 		var id = parseInt($routeParams.id);
 		$http.get('api/posts/?id='+id).success(function(data) {
 			$scope.post = Post.findById(data._embedded.posts,id);
 		});
 	}]);
