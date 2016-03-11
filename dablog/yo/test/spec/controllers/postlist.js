'use strict';

describe('Controller: PostlistctrlCtrl', function () {

  // load the controller's module
  beforeEach(module('dablogApp'));

  var PostlistctrlCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PostlistctrlCtrl = $controller('PostlistctrlCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    //TODO expect(PostlistctrlCtrl.awesomeThings.length).toBe(3);
  });
});
