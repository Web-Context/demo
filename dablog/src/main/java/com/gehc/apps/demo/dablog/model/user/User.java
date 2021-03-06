/**
 * 
 */
package com.gehc.apps.demo.dablog.model.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Lombok;
import lombok.NoArgsConstructor;

/**
 * Here is the USer entity to manage user access and authentication in a next
 * release.
 * 
 * @see Lombok#Lombok()
 * @author frederic
 *
 */
@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@NotNull
	private String id;

	@NotNull
	@Size(min = 4, max = 40)
	private String username;

	@NotNull
	@Size(min = 8, max = 40)
	private String password;

	@NotNull
	private List<UserRole> roles;

	@Size(min = 4, max = 50)
	private String firstname;

	@Size(min=0,max=500)
	private String avatar;

	@Size(min = 4, max = 50)
	private String lastname;

	@Email
	private String email;

	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdAt;

	private boolean active;

	private Date lastConnection;

	private int connectioAttemptCount;

}
