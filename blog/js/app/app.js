'use strict';

var app=angular.module('demo',[
    'ngRoute',
    'ngSanitize'
  ]);

app.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/post-list.html',
        controller: 'PostListCtrl',
        controllerAs: 'postList'
      })
      .when('/post/:id', {
        templateUrl: 'views/post-view.html',
        controller: 'PostViewCtrl',
        controllerAs: 'postView'
      })
      .when('/posts/:type', {
        templateUrl: 'views/post-list.html',
        controller: 'PostFilterCtrl',
        controllerAs: 'postFilter'
      })
      .otherwise({
        redirectTo: '/'
      });
  });