'use strict';

describe('Controller: HomeCtrl', function () {

  // load the controller's module
  beforeEach(module('dablogApp'));

  var HomeCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    HomeCtrl = $controller('HomeCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should retrieve a list of post to the scope', function () {
    expect(HomeCtrl.posts.length).toBe(9);
  });
});
