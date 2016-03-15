'use strict';

/**
 * @ngdoc service
 * @name dablogApp.user
 * @description # user Service in the dablogApp.
 */
angular.module('dablogApp').factory('UserService',
		[ '$resource', function($resource) {
			return $resource('/api/users/:username', {
				username : '@username'
			}, {
				'query' : {
					method : 'GET',
					transformResponse : function(data) {
						return angular.fromJson(data);
					}
				},
				'update' : {
					method : 'PUT',
					transformResponse : function(data) {
						return angular.fromJson(data);
					}
				},
				'remove' : {
					method : 'DELETE'
				},
				'save' : {
					method : 'POST',
					transformRequest : function(data) {
						return angular.toJson(data);
					}
				}
			});
		} ]);
