'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostfilterCtrl
 * @description
 * # PostfilterCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
  .controller('PostFilterCtrl', ['$scope', '$routeParams','$http',
	function($scope, $routeParams,$http) {
		var type     = $routeParams.type;
		var posts    = new Array();
		$scope.type  = type;
		$scope.posts = [];
		$http.get('rest/posts.json').success(function(data) {
			for (var i = 0; i < data.length; i++) {
				if(data[i].type==type){
					posts.push(data[i]);
				}
			}
			$scope.posts=posts;
		});
	}]);