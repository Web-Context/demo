'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostfilterCtrl
 * @description
 * # PostfilterCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
  .controller('PostFilterCtrl', ['$scope', '$routeParams','$http','Post',
	function($scope, $routeParams,$http,Post) {
		var type     = $routeParams.type;
		var posts    = new Array();
		$scope.type  = type;
		$scope.posts = [];
		$http.get('rest/posts.json').success(function(data) {
			$scope.posts=Post.findByType(data,type);
		});
	}]);