'use strict';

app.controller('PostListCtrl', ['$scope', '$http',
	function ($scope, $http) {
		$http.get('rest/posts.json').success(function(data) {
			$scope.posts = data;
		});

		$scope.orderProp = 'age';
	}]);

app.controller('PostViewCtrl', ['$scope', '$routeParams','$http',
	function($scope, $routeParams,$http) {
		$scope.id = $routeParams.postId;
		$http.get('rest/posts.json').success(function(data) {
			for (var i = 0; i < data.length; i++) {
				if(data[i].id==$scope.id){
					$scope.post = data;
					break;
				}
			}
		});
	}]);

app.controller('PostFilterCtrl', ['$scope', '$routeParams','$http',
	function($scope, $routeParams,$http) {
		var type     = $routeParams.type;
		var posts    = new Array();
		$scope.type  = type;
		$scope.posts = [];
		$http.get('rest/posts.json').success(function(data) {
			for (var i = 0; i < data.length; i++) {
				if(data[i].type==type){
					posts.push(data[i]);
				}
			}
			$scope.posts=posts;
		});
	}]);
