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
  .module('dablogApp', [
    'ngSanitize',
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/post-list.html',
        controller: 'HomeCtrl',
        controllerAs: 'home'
      })
      .when('/post/:uiid', {
        templateUrl: 'views/post-view.html',
        controller: 'PostViewCtrl',
        controllerAs: 'postView'
      })
      .when('/posts/:type', {
        templateUrl: 'views/post-list.html',
        controller: 'PostFilterCtrl',
        controllerAs: 'postFilter'
      })
      .when('/game/platform/:code', {
        templateUrl: 'views/post-list.html',
        controller: 'PostSearchCtrl',
        controllerAs: 'postSearchFilter'
      })
      .when('/tag/:type/:tag', {
        templateUrl: 'views/search-results.html',
        controller: 'TagSearchCtrl',
        controllerAs: 'tagSearchFilter'
      })  
      .when('/platform/:type/:platform', {
          templateUrl: 'views/search-results.html',
          controller: 'PlatformSearchCtrl',
          controllerAs: 'platformSearchFilter'
        })
      .when('/admin/user', {
        templateUrl: 'views/admin/user-list.html',
        controller: 'UserCtrl',
        controllerAs: 'userList'
      })

      .otherwise({
        redirectTo: '/'
      });
  });
