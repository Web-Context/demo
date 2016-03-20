'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PlatformSearchCtrl
 * @description
 * # PlatformSearchCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
.controller('PlatformSearchCtrl', ['$scope','$routeParams','PlatformSearchService',function($scope, $routeParams, PlatformSearchService) {
	PlatformSearchService
	    .findByPlatform(
	        {
	          'type' : $routeParams.type,
	          'platform' : $routeParams.platform
	        },
	        function(response) {
	        	$scope.search= $routeParams.type + ' > ' + $routeParams.platform; 
	            $scope.results = response._embedded.posts ? response._embedded.posts
	                : [];
	        });
} ]);