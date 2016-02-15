'use strict';

var app=angular.module('demo',['ngRoute']);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/post', {
        templateUrl: 'views/post-list.html',
        controller: 'PostListCtrl',
        controllerAs: 'postList'
      }).
      when('/post/:postId', {
        templateUrl: 'views/post-view.html',
        controller: 'PostViewCtrl',
        controllerAs: 'postView'
      }).
      when('/posts/:type', {
        templateUrl: 'views/post-list.html',
        controller: 'PostFilterCtrl',
        controllerAs: 'postFilter'
      }).
      otherwise({
        redirectTo: '/post'
      });
  }]);
