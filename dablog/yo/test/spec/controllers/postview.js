'use strict';

describe('Controller: PostviewctrlCtrl', function () {

  // load the controller's module
  beforeEach(module('dablogApp'));

  var PostviewctrlCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PostviewctrlCtrl = $controller('PostViewCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    //TODO expect(PostViewCtrl.awesomeThings.length).toBe(3);
  });
});
