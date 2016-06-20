'use strict';

/**
 * @ngdoc function
 * @name dablogApp.controller:MenuCtrl
 * @description
 * # MenuCtrl
 * Controller of the dablogApp
 */
angular.module('dablogApp')
  .controller('MenuCtrl', ['$scope','$location','UserService','$uibModal',function ($scope,$location,UserService,$uibModal) {
    
    $scope.user= {};


    $scope.selectedClass = function(route) {
        var selected = (route === $location.path()?'selected':'');
        return selected;
    };

    $scope.menuItems = [
        {'url':'/','label':'Home','tooltip':'back home','accesskey':'H','priority':1},
        {'url':'/posts/movie','label':'Movie','tooltip':'What\'s new on big screen ?','accesskey':'M','priority':2},
        {'url':'/posts/game','label':'Video Game','tooltip':'How to feed my Console','accesskey':'G','priority':3},
    ];

    $scope.open = function (size) {

        var modalInstance = $uibModal.open({
          animation: $scope.animationsEnabled,
          templateUrl: 'loginForm.html',
          controller: 'ModalInstanceCtrl',
          size: size,
          resolve: {
            items: function () {
              return $scope.items;
            }
          }
        });

        modalInstance.result.then(function (selectedItem) {
          $scope.selected = selectedItem;
        }, function () {
          $log.info('Modal dismissed at: ' + new Date());
        });
      };

  }]);

// Please note that $uibModalInstance represents a modal window (instance) dependency.
// It is not the same as the $uibModal service used above.

angular.module('dablogApp').controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, items) {

  $scope.ok = function () {
    $uibModalInstance.close($scope.selected.item);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
});