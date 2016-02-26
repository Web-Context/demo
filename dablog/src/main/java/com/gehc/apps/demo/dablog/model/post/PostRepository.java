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

	/**
	 * Find all {@link Post} on there type.
	 * 
	 * @param type
	 * @return
	 */
	public List<Post> findByType(@Param("type") String type);

	/**
	 * Retrieve posts based on there type and search for title containing the
	 * search string.
	 * 
	 * @param type
	 * @param title
	 * @return
	 */
	public List<Post> findByTypeAndTitleLikeIgnoreCase(@Param("type") String type, @Param("title") String title);
}
