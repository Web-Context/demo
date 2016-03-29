app.factory('PostService', function() {
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
					var post = data[i];
					post.createdAt=new Date(post.createdAt);
					post.publishedAt=new Date(post.publishedAt);
					posts.push(post);
				}
			}
 			return posts; 
 		},
		findByTag: function(data,tag){
			var posts = [];
			for (var i = 0; i < data.length; i++) {
				if(data[i].tags.contains(type)){
					var post = data[i];
					post.createdAt=new Date(post.createdAt);
					post.publishedAt=new Date(post.publishedAt);
					posts.push(post);
				}
			}
 			return posts; 
 		},
		findByPlatform: function(data,platform){
			var posts = [];
			for (var i = 0; i < data.length; i++) {
				if(data[i].platforms.contains(platform)){
					var post = data[i];
					post.createdAt=new Date(post.createdAt);
					post.publishedAt=new Date(post.publishedAt);
					posts.push(post);
				}
			}
 			return posts; 
 		},
 		findByTitle: function(data,title){
			var posts = [];
			for (var i = 0; i < data.length; i++) {
				if((""+data[i].title).toLowerCase().indexOf((""+title).toLowerCase()) > -1){
					var post = data[i];
					post.createdAt=new Date(post.createdAt);
					post.publishedAt=new Date(post.publishedAt);
					posts.push(post);
				}
			}
 			return posts; 
 		}
 	};
 });
app.factory('UserService', ['$http',function($http) {
 	return {
 		formatData : function(response){
 			var data = [];
 			for(var i=0;i<response.length;i++){
				var user = response[i];
				user.createdAt=new Date(user.createdAt);
				user.lastConnection=new Date(post.lastConnection);
				data.push(user);
			}
 			return data;
 		},
 		findByUsername: function(request,username){
			var serviceResponse = {'_embedded':{'users':[]}};
	        $http.get('rest/users.json')
    	        .success(function(response) {

					var data = [];
					for(var i=0;i<response.length;i++){
						var user = response[i];
						if(request.username===user.username){
							user.createdAt=new Date(user.createdAt);
							user.lastConnection=new Date(user.lastConnection);
							data.push(user);
						}
					}

        	        serviceResponse._embedded.users = data;
		 			return serviceResponse;
        	});
 		}
 	};
}]);