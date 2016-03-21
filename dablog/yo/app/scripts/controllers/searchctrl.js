'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:TagSearchCtrl
 * @description
 * # TagSearchCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
.controller('SearchCtrl', ['$scope','$routeParams','TagSearchService',function($scope, $routeParams, TagSearchService) {
	TagSearchService
	    .findByTag(
	        {
	          'type' : $routeParams.type,
	          'tag' : $routeParams.tag,
	          'platform' : $routeParams.platform
	        },
	        function(response) {
	        	$scope.search = $routeParams.type + ' > ' + $routeParams.platform + ' > ' + $routeParams.tag;
	            $scope.results = response._embedded.posts ? response._embedded.posts
	                : [];
	        });
} ]);