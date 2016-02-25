/**
 * 
 */
package com.gehc.apps.demo.dablog.model.post;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Basic repository for Post entity.
 * 
 * @author Frederic Delorme
 *
 */
public interface PostRepository extends MongoRepository<Post, String> {
	
	public List<Post> findByType(@Param("type") String type);
	
	public List<Post> findByTypeAndTitleLikeIgnoreCase(@Param("type") String type,@Param("title") String title);
}
