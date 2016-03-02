'use strict';

describe('Controller: PostViewCtrl', function () {

  // load the controller's module
  beforeEach(module('dablogApp'));

  var PostViewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PostViewCtrl = $controller('PostViewCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should retrieve a lot of game for type "game"', function () {
    expect(PostViewCtrl.findByType('game').length).toBe(9);
  });
});
