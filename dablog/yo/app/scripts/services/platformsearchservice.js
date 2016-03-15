'use strict';

angular.module('dablogApp')
.factory('PlatformSearchService',['$resource',function($resource) {
    return $resource(
        '/api/posts/search/findByTypeAndPlatformIgnoreCase?type=:type&platform=:platform',
        {
            type : '@type',
            platform : '@platform'
        }, {
            'findByPlatform' : {
              method : 'GET',
              action : 'findByTypeAndPlatformsIgnoreCase',
              transformResponse : function(data) {
                  return angular.fromJson(data);
              }
            }
        });
} ]);