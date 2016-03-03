'use strict';

angular.module('dablogApp').factory('PlatformService',
		[ '$resource', function($resource) {
			return $resource('/api/platform/:id', {
				id : '@id'
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
			}, {});
		} ]);