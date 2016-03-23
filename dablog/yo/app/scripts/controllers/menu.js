'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:MenuCtrl
 * @description
 * # MenuCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
  .controller('MenuCtrl', ['$scope','$location','UserService',function ($scope,$location,UserService) {
    $scope.selectedClass = function(route) {
    	var selected = (route === $location.path()?'selected':'');
        return selected;
    };

    $scope.menuItems = [
        {'url':'/','label':'Home','tooltip':'back home','accesskey':'H','priority':1},
        {'url':'/posts/movie','label':'Movie','tooltip':'What\'s new on big screen ?','accesskey':'M','priority':2},
        {'url':'/posts/game','label':'Video Game','tooltip':'How to feed my Console','accesskey':'G','priority':3},
    ];

    $scope.showLogin = function(){
        $scope.loginDisplay=true;
    };

    $scope.login = function(){
        UserService.findByUsername({'username':'mcgivrer'},function(data){        
            if(data._embedded.users[0].avatar==='gravatar'){
                data._embedded.users[0].avatar=gravatar(data._embedded.users[0].email);
            }
            $scope.user = data._embedded.users[0];
        });
    };

    $scope.logout = function(){
        $scope.user=null;
    };

    $scope.preferences = function(){
        alert("display preference dialog !");
    };
    $scope.register = function(){
        alert("display register dialog !");
    };

  }]);
