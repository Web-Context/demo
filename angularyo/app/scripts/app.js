'use strict';

/**
 * @ngdoc overview
 * @name angularyoApp
 * @description
 * # angularyoApp
 *
 * Main module of the application.
 */
angular
  .module('angularyoApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
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
