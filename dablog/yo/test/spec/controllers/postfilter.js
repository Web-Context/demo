'use strict';

describe('Controller: PostfilterCtrl', function () {

  // load the controller's module
  beforeEach(module('dablogApp'));

  var PostfilterCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PostfilterCtrl = $controller('PostfilterCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    //TODO expect(PostfilterCtrl.awesomeThings.length).toBe(3);
  });
});
