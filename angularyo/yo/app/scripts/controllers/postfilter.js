'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostfilterCtrl
 * @description
 * # PostfilterCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
  .controller('PostFilterCtrl', ['$scope', '$routeParams','$http','Post','Platform',
	function($scope, $routeParams,$http,Post,Platform) {
		var type     = $routeParams.type;
		$scope.type  = type;
		$scope.posts = [];
		$http.get('rest/posts.json?'+type).success(function(data) {
			$scope.posts=Post.findByType(data,type);
		});

		if(type==="game"){
			$http.get('rest/platforms.json?all').success(function(data) {
				$scope.platforms=Platform.formatData(data);
			});
		}

	}]);