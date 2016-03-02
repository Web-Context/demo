'use strict';

angular.module('dablogApp')
.factory('PostFilterByTypeService',['$resource',function($resource) {
    return $resource(
        '/api/posts/search/findByType?type=:type',
        {
          type : '@type'
        }, {
            'findByType' : {
              method : 'GET',
              action : 'findByType',
              params: {type:'@type'},
              isArray: false,
              transformResponse : function(data) {
                  return angular.fromJson(data);
              }
            }
        }, {});
} ]);