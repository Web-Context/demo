'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostlistctrlCtrl
 * @description
 * # PostlistctrlCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
 .controller('PostListCtrl', ['$scope', '$http',
 	function ($scope, $http) {
 		$http.get('rest/posts.json').success(function(data) {
 			$scope.posts = data;
 		});

 		$scope.orderProp = 'age';
 	}]);