'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostviewctrlCtrl
 * @description
 * # PostviewctrlCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
 .controller('PostViewCtrl', ['$scope', '$routeParams','PostService',
 	function($scope, $routeParams,PostService) {
 		var uiid = $routeParams.uiid;
 		PostService.findByUiid({'uiid':uiid},function(response){
 			$scope.post = response;
 		});
 	}]);
