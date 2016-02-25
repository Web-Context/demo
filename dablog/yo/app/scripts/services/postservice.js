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
				post.publishedAt=new Date(post.publishedAt);
				data.push(post);
			}
 			return data;
 		},
 		formatItem:function (post){
				post.createdAt=new Date(post.createdAt);
				post.publishedAt=new Date(post.publishedAt);
			return post; 			
 		},
 		findById: function(data,id){
			var post = {};
			for (var i = 0; i < data.length; i++) {
				if(data[i].id===id){	
					post = data[i];
					post.createdAt=new Date(post.createdAt);
					post.publishedAt=new Date(post.publishedAt);
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
					post.publishedAt=new Date(post.publishedAt);
					posts.push(post);
				}
			}
 			return posts; 
 		}
 	};
 });