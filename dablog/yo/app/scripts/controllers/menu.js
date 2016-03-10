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

    $scope.menuItems = [
        {'url':'/','label':'Home','tooltip':'back home','accesskey':'H','priority':1},
        {'url':'/posts/movie','label':'Movie','tooltip':'What\'s new on big screen ?','accesskey':'M','priority':2},
        {'url':'/posts/game','label':'Video Game','tooltip':'How to feed my Console','accesskey':'G','priority':3},
    ];


    $scope.login = function(){
        $scope.user = {
            'url':'profile/00117898665765',
            'username':'McGivrer',
            'firstname':'Frédéric',
            'lastname':'Delorme',
            'email':'frederic.delorme@web-context.com',
            'avatar':'https://trello-avatars.s3.amazonaws.com/372550260169a4891d0c419fb7af6b87/170.png',
        };

    }

    $scope.logout = function(){
        $scope.user=null;
    }

    $scope.preferences = function(){
        alert("display preference dialog !");
    }
    $scope.register = function(){
        alert("display register dialog !");
    }

  }]);
