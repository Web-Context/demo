'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostviewctrlCtrl
 * @description
 * # PostviewctrlCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
 .controller('PostViewCtrl', ['$scope', '$routeParams','PostFilterByUiidService',
 	function($scope, $routeParams,PostFilterByUiidService) {
 		var uiid = $routeParams.uiid;
 		PostFilterByUiidService.findByUiid({'uiid':uiid},function(response){
 			$scope.post = response;
 		});
 	}]);
