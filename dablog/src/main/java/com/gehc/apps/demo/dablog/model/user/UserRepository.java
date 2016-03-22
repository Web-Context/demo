/**
 * 
 */
package com.gehc.apps.demo.dablog.model.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Entity to manage User.
 * 
 * @author Frederic Delorme
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * retrieve a user on its <code>username</code>.
	 * 
	 * @param username
	 *            user's user name to retrieve.
	 * @return the corresponding User entity.
	 */
	public User findByUsername(@Param("username") String username);

	public default User authenticateAndLogin(String username, String password) throws UnknownUserException {
		User user = findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			throw new UnknownUserException(String.format("user %s not authorized", username));
		}
	}

	/**
	 * return true if <code>password</code> correspond to user from
	 * <code>username</code>'s password
	 * 
	 * @param username
	 *            of the logged in user.
	 * @param password
	 *            password input by human.
	 * @return true if password match the User entity's one.
	 */

	public default boolean authenticate(@Param("username") String username, @Param("password") String password) {
		User user = findByUsername(username);
		return user.getPassword().equals(password);
	};
}
