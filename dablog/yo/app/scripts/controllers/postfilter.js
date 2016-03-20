'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostlistctrlCtrl
 * @description
 * # PostlistctrlCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
.controller('PostFilterCtrl', ['$scope', '$routeParams','PostFilterByTypeService',
 function ($scope, $routeParams, PostFilterByTypeService) {
	var type = $routeParams.type;
    PostFilterByTypeService.findByType(
    		{
    			'type' : type
    		},
    		function(response) {
    			$scope.posts = response._embedded.posts ? response._embedded.posts
    					: [];
    		});
}]);