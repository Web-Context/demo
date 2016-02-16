'use strict';

/**
 * @ngdoc function
 * @name angularyoApp.controller:PostlistctrlCtrl
 * @description
 * # PostlistctrlCtrl
 * Controller of the angularyoApp
 */
angular.module('angularyoApp')
 .controller('PostListCtrl', ['$scope', '$http', 'Post',
 	function ($scope, $http, Post) {
 		$http.get('rest/posts.json')
 			.success(function(response) {
				$scope.posts = Post.formatData(response);
 		});
 	}]);