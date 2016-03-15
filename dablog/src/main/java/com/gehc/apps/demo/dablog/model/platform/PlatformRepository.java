package com.gehc.apps.demo.dablog.model.platform;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Basic repository for Post entity.
 * 
 * @author Frederic Delorme
 *
 */
public interface PlatformRepository extends MongoRepository<Platform, String> {

	/**
	 * Retrieve a post on its unique Id.
	 * 
	 * @param id
	 * @return
	 */
	public Platform findById(@Param("id") String id);

	/**
	 * Retrieve Platform on its code.
	 * 
	 * @param code
	 * @return
	 */
	public Platform findByCode(@Param("code") String code);

}
