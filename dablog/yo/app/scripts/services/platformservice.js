angular.module('dablogApp')
 .factory('Platform', function() {
 	return {
 		formatData : function(response){
 			var data = [];
 			for(var i=0;i<response.length;i++){
				var platform = response[i];
				platform.availabilityDate=new Date(platform.availabilityDate);
				platform.createdAt=new Date(platform.createdAt);
				data.push(platform);
			}
 			return data;
 		},
 		findById: function(data,id){
			var platform = {};
			for (var i = 0; i < data.length; i++) {
				if(data[i].id===id){
					var platform = data[i];
					platform.availabilityDate=new Date(platform.availabilityDate);
					platform.createdAt=new Date(platform.createdAt);
					break;
				}
			}
 			return platform;

 		},
 		findByType: function(data,type){
			var platforms = [];
			for (var i = 0; i < data.length; i++) {
				if(data[i].type===type){
					var platform = data[i];
					platform.availabilityDate=new Date(platform.availabilityDate);
					platform.createdAt=new Date(platform.createdAt);
					platforms.push(platform);
				}
			}
 			return platforms; 
 		}
 	};
 });