package com.gehc.apps.demo.dablog.model.post;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Basic repository for Post entity.
 * 
 * @author Frederic Delorme
 *
 */
public interface PostRepository extends MongoRepository<Post, String> {

	/**
	 * Retrieve a post on its unique Id.
	 * 
	 * @param id
	 * @return
	 */
	public Post findById(@Param("id") String id);

	/**
	 * Retrieve a post on its unique Id.
	 * 
	 * @param id
	 * @return
	 */
	public Post findByUiid(@Param("uiid") String uiid);

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

	/**
	 * Retrieve posts based on there type and search for a specific tag.
	 * 
	 * @param type
	 * @param tag 
	 * @return
	 */
	@Query("{ 'type':?0, 'metadata.tags':{$in:[?1] }}}")
	public List<Post> findByTypeAndTagsIgnoreCase(@Param("type") String type, @Param("tag") String tag);
	
	/**
	 * Retrieve posts based on there type and search for a specific platform.
	 * 
	 * @param type
	 * @param platform
	 * @return
	 */
	@Query("{ 'type':?0, 'metadata.platforms':{$in:[?1] }}}")
	public List<Post> findByTypeAndPlatformIgnoreCase(@Param("type") String type, @Param("platform") String platform);

}
