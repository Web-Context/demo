'use strict';

angular.module('dablogApp')
.factory('TagSearchService',['$resource',function($resource) {
    return $resource(
        '/api/posts/search/findByTypeAndTagsIgnoreCase?type=:type&tag=:tag',
        {
            type : '@type',
            title : '@title'
        }, {
            'findByTag' : {
              method : 'GET',
              action : 'findByTypeAndTagsIgnoreCase',
              transformResponse : function(data) {
                  return angular.fromJson(data);
              }
            }
        });
} ]);