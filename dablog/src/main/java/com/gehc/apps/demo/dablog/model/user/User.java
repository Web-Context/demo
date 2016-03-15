/**
 * 
 */
package com.gehc.apps.demo.dablog.model.user;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author frederic
 *
 */
public class User {
	@Id
	@NotNull
	private String id;
	
	@NotNull
	@Size(min=4, max=40)
	private String username;

	@NotNull
	@Size(min = 8, max = 40)
	private String password;

	@NotNull
	private UserRole[] roles;

	@Size(min = 4, max = 50)
	private String firstname;

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

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param roles
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param createdAt
	 * @param active
	 * @param lastConnection
	 * @param connectioAttemptCount
	 */
	public User(String username, String password, UserRole[] roles, String firstname, String lastname, String email,
			Date createdAt, boolean active, Date lastConnection, int connectioAttemptCount) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.createdAt = createdAt;
		this.active = active;
		this.lastConnection = lastConnection;
		this.connectioAttemptCount = connectioAttemptCount;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public UserRole[] getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(UserRole[] roles) {
		this.roles = roles;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the lastConnection
	 */
	public Date getLastConnection() {
		return lastConnection;
	}

	/**
	 * @param lastConnection
	 *            the lastConnection to set
	 */
	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	/**
	 * @return the connectioAttemptCount
	 */
	public int getConnectioAttemptCount() {
		return connectioAttemptCount;
	}

	/**
	 * @param connectioAttemptCount
	 *            the connectioAttemptCount to set
	 */
	public void setConnectioAttemptCount(int connectioAttemptCount) {
		this.connectioAttemptCount = connectioAttemptCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + connectioAttemptCount;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastConnection == null) ? 0 : lastConnection.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(roles);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (active != other.active) {
			return false;
		}
		if (connectioAttemptCount != other.connectioAttemptCount) {
			return false;
		}
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		} else if (!firstname.equals(other.firstname)) {
			return false;
		}
		if (lastConnection == null) {
			if (other.lastConnection != null) {
				return false;
			}
		} else if (!lastConnection.equals(other.lastConnection)) {
			return false;
		}
		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (!Arrays.equals(roles, other.roles)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=").append(username).append(", password=").append(password).append(", roles=")
				.append(Arrays.toString(roles)).append(", firstname=").append(firstname).append(", lastname=")
				.append(lastname).append(", email=").append(email).append(", createdAt=").append(createdAt)
				.append(", active=").append(active).append(", lastConnection=").append(lastConnection)
				.append(", connectioAttemptCount=").append(connectioAttemptCount).append("]");
		return builder.toString();
	}

}
