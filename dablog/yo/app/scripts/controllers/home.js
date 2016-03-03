'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
  .controller('HomeCtrl', ['$scope','PostService','$location',function ($scope, PostService, $location) {
    PostService.query(
		{},
		function(response) {
			$scope.posts = response._embedded.posts ? response._embedded.posts : [];
		}
	);
  }]);
