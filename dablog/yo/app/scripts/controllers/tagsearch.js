'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:TagSearchCtrl
 * @description
 * # TagSearchCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
.controller('TagSearchCtrl', ['$scope','$routeParams','TagSearchService',function($scope, $routeParams, TagSearchService) {
	TagSearchService
	    .findByTag(
	        {
	          'type' : $routeParams.type,
	          'tag' : $routeParams.tag
	        },
	        function(response) {
	        	$scope.search = $routeParams.type + ' > ' + $routeParams.tag;
	            $scope.results = response._embedded.posts ? response._embedded.posts
	                : [];
	        });
} ]);