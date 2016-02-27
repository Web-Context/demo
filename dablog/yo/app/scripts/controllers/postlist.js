'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:PostlistctrlCtrl
 * @description
 * # PostlistctrlCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
 .controller('PostListCtrl', ['$scope', '$http', 'Post',
 	function ($scope, $http, Post) {
 		$http.get('api/posts')
 			.success(function(response) {
				$scope.posts = Post.formatData(response._embedded.posts);
 		});
 	}]);