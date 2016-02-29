'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostfilterCtrl
 * @description
 * # PostfilterCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
  .controller('PostFilterCtrl', ['$scope', '$routeParams','$http','Post','Platform',
	function($scope, $routeParams,$http,Post,Platform) {
		var type     = $routeParams.type;
		$scope.type  = type;
		$scope.posts = [];
		$http.get('api/posts/search/findByType?type='+type).success(function(data) {
			$scope.posts=Post.findByType(data._embedded.posts,type);
		});

		if(type==='game'){
			$http.get('api/posts/search/findByType?type='+type).success(function(data) {
				$scope.platforms=Platform.formatData(data._embedded.posts);
			});
		}

	}]);