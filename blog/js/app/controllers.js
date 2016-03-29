'use strict';

app.controller('HomeCtrl', ['$scope', '$routeParams', '$http', '$location','UserService',
    function($scope, $routeParams, $http, $location, UserService) {

        $scope.menuItems = [
        {
            id: '1',
            url: '/',
            label: 'Home',
            accesskey: 'H',
            tooltip: 'Back to home',
            priority:1,
            subItems:[]
        },
        {
            id: '2',
            url: '/posts/game',
            label: 'Games',
            accesskey: 'G',
            tooltip: 'Show me all games',
            priority:2,
            subItems:[
                {id:'1',url:'/platform/x360',label:'X360',accesskey:'X',tooltip:'view all game from old M. Microsoft',priority:'1'},
                {id:'2',url:'/platform/wiiu',label:'WiiU',accesskey:'W',tooltip:'Where are the platform about Nintendo',priority:'2'}
            ]
        }, 
        {
            id: '3',
            url: '/posts/movie',
            label: 'Movies',
            accesskey: 'M',
            tooltip: 'View movies news',
            priority:3,
            subItems:[]
        }];

        $scope.menuItem = $scope.menuItems[$routeParams.item];

        $scope.selectedClass = function(route) {
            var selected = (route === $location.path()?'selected':'');
            return selected;
        };

        UserService.findByUsername({'username':'mcgivrer'},function(data){
            if(data._embedded.users[0].avatar==='gravatar'){
                data._embedded.users[0].avatar=gravatar(data._embedded.users[0].email);
            }
            $scope.user = data._embedded.users[0];
        });




    }
    ]);

app.controller('PostListCtrl', ['$scope', '$http', 'PostService',
    function($scope, $http, PostService) {
        $http.get('rest/posts.json')
        .success(function(response) {
            $scope.posts = PostService.formatData(response);
        });
    }
    ]);

app.controller('PostViewCtrl', ['$scope', '$routeParams', '$http', 'PostService',
    function($scope, $routeParams, $http, PostService) {
        var id = parseInt($routeParams.id);
        $http.get('rest/posts.json').success(function(data) {
            $scope.post = PostService.findById(data, id);
        });
    }
    ]);

app.controller('PostFilterCtrl', ['$scope', '$routeParams', '$http', 'PostService',
    function($scope, $routeParams, $http, PostService) {
        var type = $routeParams.type;
        $scope.type = type;
        $scope.posts = [];
        $http.get('rest/posts.json').success(function(data) {
            $scope.posts = PostService.findByType(data, type);
        });
    }
    ]);
app.controller('TagFilterCtrl', ['$scope', '$routeParams', '$http', 'PostService',
    function($scope, $routeParams, $http, PostService) {
        var tag = $routeParams.tag;
        $scope.tag = tag;
        $scope.posts = [];
        $http.get('rest/posts.json').success(function(data) {
            $scope.posts = PostService.findByTag(data, tag);
        });
    }
    ]);