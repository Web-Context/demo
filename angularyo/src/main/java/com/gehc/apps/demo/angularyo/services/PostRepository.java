/**
 * 
 */
package com.gehc.apps.demo.angularyo.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gehc.apps.demo.angularjs.model.Post;

/**
 * Basic repository for Post entity.
 * 
 * @author Frederic Delorme
 *
 */
public interface PostRepository extends MongoRepository<Post, String> {

}
