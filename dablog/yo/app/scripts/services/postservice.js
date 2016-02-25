'use strict';

/**
 * @ngdoc service
 * @name dablogApp
 * @description
 * # PostService
 * Service in the dablogApp.
 */
 angular.module('dablogApp')
 .factory('Post', function() {
 	return {
 		formatData : function(response){
 			var data = [];
 			for(var i=0;i<response.length;i++){
				var post = response[i];
				
				post.createdAt=new Date(post.createdAt);
				post.publicationAt=new Date(post.publicationAt);
				data.push(post);
			}
 			return data;
 		},
 		formatItem:function (post){
				post.createdAt=new Date(post.createdAt);
				post.publicationAt=new Date(post.publicationAt);
			return post; 			
 		},
 		findById: function(data,id){
			var post = {};
			for (var i = 0; i < data.length; i++) {
				if(data[i].id===id){	
					post = data[i];
					post.createdAt=new Date(post.createdAt);
					post.publicationAt=new Date(post.publicationAt);
				break;
				}
			}
 			return post;

 		},
 		findByType: function(data,type){
			var posts = [];
			for (var i = 0; i < data.length; i++) {
				if(data[i].type===type){
					var post =  data[i];
					post.createdAt=new Date(post.createdAt);
					post.publicationAt=new Date(post.publicationAt);
					posts.push(post);
				}
			}
 			return posts; 
 		}
 	};
 });