'use strict';

/**
 * @ngdoc service
 * @name dablogApp
 * @description # PostService Service in the dablogApp.
 */
angular.module('dablogApp').factory('PostService',
		[ '$resource', function($resource) {
			return $resource('/api/posts/:uiid', {
				id : '@uiid'
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
				},
				'findByUiid' : {
					method : 'GET',
					action : 'findByUiid',
					params : {
						uiid : '@uiid'
					},
					transformRequest : function(data) {
						return angular.toJson(data);
					}
				}
			});
		} ]);
