package com.gehc.apps.demo.dablog.model.platform;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Basic repository for Platform entity.
 * 
 * @author Frederic Delorme
 *
 */
public interface PlatformRepository extends MongoRepository<Platform, String> {

	/**
	 * Retrieve a Platform on its unique Id.
	 * 
	 * @param id
	 * @return
	 */
	public Platform findById(@Param("id") String id);

	/**
	 * Find all {@link Platform} on there code.
	 * 
	 * @param code
	 * @return
	 */
	public List<Platform> findByCode(@Param("code") String code);
}
