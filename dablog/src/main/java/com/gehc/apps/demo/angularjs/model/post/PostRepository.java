/**
 * 
 */
package com.gehc.apps.demo.angularjs.model.post;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Basic repository for Post entity.
 * 
 * @author Frederic Delorme
 *
 */
public interface PostRepository extends MongoRepository<Post, String> {

}
