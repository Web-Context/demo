'use strict';

var app=angular.module('dablog',[
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
      .when('/search', {
        templateUrl: 'views/post-list.html',
        controller: 'HomeCtrl',
        controllerAs: 'searchList'
      })
      .when('/posts/:type', {
        templateUrl: 'views/post-list.html',
        controller: 'PostFilterCtrl',
        controllerAs: 'postFilter'
      })
      .when('/tags/:tag', {
        templateUrl: 'views/post-list.html',
        controller: 'TagFilterCtrl',
        controllerAs: 'tagFilter'
      })
      .when('/platform/:platform', {
        templateUrl: 'views/post-list.html',
        controller: 'PlatformFilterCtrl',
        controllerAs: 'platformFilter'
      })
      .otherwise({
        redirectTo: '/'
      });
  });