'use strict';

angular.module('dablogApp')
.factory('PostSearchService',['$resource',function($resource) {
    return $resource(
        '/api/posts/search/findByTypeAndTitleIgnoreCase?type=:type&title=:title',
        {
            type : '@type',
            title : '@title'
        }, {
            'findByTitleLike' : {
              method : 'GET',
              action : 'findByTypeAndTitleIgnoreCase',
              transformResponse : function(data) {
                  return angular.fromJson(data);
              }
            }
        });
} ]);