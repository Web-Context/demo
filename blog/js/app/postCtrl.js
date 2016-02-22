'use strict';

'use strict';

app.controller('HomeCtrl', ['$scope', '$routeParams', function($scope,$routeParams){
	$scope.menuItems = [
		{id:'1',url:'#/',label:'Home',accesskey:'H',tooltip:'Back to home'},
		{id:'2',url:'#/posts/game',label:'Games',accesskey:'G',tooltip:'Show me all games'},
		{id:'3',url:'#/posts/movie',label:'Movies',accesskey:'M',tooltip:'View movies news'}
	];
	$scope.menuItem = $routeParams.item;
}]);

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