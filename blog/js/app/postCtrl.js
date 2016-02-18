'use strict';

'use strict';


app.controller('PostListCtrl', ['$scope', '$http', 'Post',
 	function ($scope, $http, Post) {
 		$http.get('rest/posts.json')
 			.success(function(response) {
				$scope.posts = Post.formatData(response);
 		});
 	}]);

app.controller('PostViewCtrl', ['$scope', '$routeParams','$http','Post',
 	function($scope, $routeParams,$http,Post) {
 		var id = parseInt($routeParams.id);
 		$http.get('rest/posts.json').success(function(data) {
 			$scope.post = Post.findById(data,id);
 		});
 	}]);

app.controller('PostFilterCtrl', ['$scope', '$routeParams','$http','Post',
	function($scope, $routeParams,$http,Post) {
		var type     = $routeParams.type;
		$scope.type  = type;
		$scope.posts = [];
		$http.get('rest/posts.json').success(function(data) {
			$scope.posts=Post.findByType(data,type);
		});
	}]);