'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:MenuCtrl
 * @description
 * # MenuCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
  .controller('MenuCtrl', ['$scope','$location',function ($scope,$location) {
    $scope.selectedClass = function(route) {
    	var selected = (route === $location.path()?'selected':'');
        return selected;
    };
  }]);
