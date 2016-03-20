'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:AdminUserCtrl
 * @description
 * # AdminUserCtrl
 * Controller of the dablogApp
 */
 angular.module('dablogApp')
 .controller('AdminUserCtrl', ['$scope','UserService',function ($scope,UserService) {
 	UserService.query(function(data){
 		$scope.users = data._embedded.users;
 	});
 }]);
