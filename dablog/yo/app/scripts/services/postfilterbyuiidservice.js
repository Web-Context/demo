'use strict';

angular.module('dablogApp')
.factory('PostFilterByUiidService',['$resource',function($resource) {
    return $resource(
        '/api/posts/search/findByUiid?uiid=:uiid',
        {
        	uiid : '@uiid'
        }, {
            'findByUiid' : {
              method : 'GET',
              action : 'findByUiid',
              params: {uiid:'@uiid'},
              isArray: false,
              transformResponse : function(data) {
                  return angular.fromJson(data);
              }
            }
        }, {});
} ]);