'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostfilterCtrl
 * @description
 * # PostfilterCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
.controller('PostSearchCtrl', ['$scope','$routeParams','PostSearchService',function($scope, $routeParams, PostSearchService) {
	PostSearchService
	    .findByTypeAndTitleIgnoreCaseLike(
	        {
	          'type' : $routeParams.type,
	          'title' : $routeParams.title
	        },
	        function(response) {
	            $scope.results = response._embedded.post ? response._embedded.post
	                : [];
	        });
} ]);