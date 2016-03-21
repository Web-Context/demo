'use strict';

angular.module('dablogApp')
.factory('SearchService',['$resource',function($resource) {
    return $resource(
        '/api/posts/search/findByTypeAndTagsIgnoreCaseAndPlatformIgnoreCase?type=:type&tag=:tag&platform=:platform',
        {
            type : '@type',
            tag : '@tag',
            platform: '@platform'
        }, {
            'searchByTypeAndTagAndPlatform' : {
              method : 'GET',
              action : 'findByTypeAndTagsIgnoreCaseAndPlatformIgnoreCase',
              transformResponse : function(data) {
                  return angular.fromJson(data);
              }
            }
        });
} ]);