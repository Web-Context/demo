package com.gehc.apps.demo.dablog.model.platform;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

/**
 * <p>This is a class to manage Game Platform on the Blog.</p>
 * <p>Sample JSON document from MongoDb.</p>
 * <pre>{
 *   "name" : "Microsoft Xbox 360",
 *   "accesskey" : "X",
 *   "id" : 1,
 *   "availabilityDate" : "2005-11-22 00:00:00",
 *   "manufacturer" : "Flextronics, Wistron, Celestica, Foxconn",
 *   "createdAt" : "2015-07-01 16:48:23",
 *   "code" : "x360",
 *   "developer" : "Microsoft",
 *   "pictures" : {
 *       "big" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL1000_.jpg",
 *      "medium" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL500_.jpg",
 *      "small" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL250_.jpg"
 *  	}
 *	}</pre>
 * 
 * @author Frederic Delorme
 *
 */
@Data
@ToString(includeFieldNames = true)
public class Platform {

	@Id
	@NotNull
	private String id;
	@NotNull
	@Size(min = 2, max = 6)
	private String code;
	@Size(min = 2, max = 40)
	private String name;
	@Size(min = 2, max = 60)
	private String developer;
	@Size(min = 2, max = 60)
	private String manufacturer;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdAt;
	private Map<String, String> pictures;

}
=======
/**
 * 
 */
package com.gehc.apps.demo.dablog.model.platform;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * This is a class to manage game execution platform.
 *
 *
 *  here a sample entity from json mongodb doc.
 *	{
 *   "name" : "Microsoft Xbox 360",
 *   "accesskey" : "X",
 *   "availabilityDate" : "2005-11-22 00:00:00",
 *   "manufacturer" : "Flextronics, Wistron, Celestica, Foxconn",
 *   "createdAt" : "2015-07-01 16:48:23",
 *   "code" : "x360",
 *   "developer" : "Microsoft",
 *   "pictures" : {
 *       "big" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL1000_.jpg",
 *       "medium" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL500_.jpg",
 *       "small" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL250_.jpg"
 *   }
 *   
 * @author Frederic Delorme
 *
 */
public class Platform {
	@Id
	@NotNull
	private String id;

	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	@NotNull
	private String code;

	@Size(min = 0, max = 100)
	private String manufacturer;
	@Size(min = 0, max = 100)
	private String developer;

	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date availabilityDate;

	@CreatedBy
	private String createdBy;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date publicationAt;

	private Map<String, String> pictures;

	
	/**
	 * Default Constructor
	 */
	public Platform() {
	}
	
	
	/**
	 * @param name
	 * @param code
	 * @param manufacturer
	 * @param developer
	 * @param createdAt
	 * @param availabilityDate
	 * @param createdBy
	 * @param publicationAt
	 * @param pictures
	 */
	public Platform(String name, String code, String manufacturer, String developer, Date createdAt,
			Date availabilityDate, String createdBy, Date publicationAt, Map<String, String> pictures) {
		super();
		this.name = name;
		this.code = code;
		this.manufacturer = manufacturer;
		this.developer = developer;
		this.createdAt = createdAt;
		this.availabilityDate = availabilityDate;
		this.createdBy = createdBy;
		this.publicationAt = publicationAt;
		this.pictures = pictures;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the developer
	 */
	public String getDeveloper() {
		return developer;
	}

	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the availabilityDate
	 */
	public Date getAvailabilityDate() {
		return availabilityDate;
	}

	/**
	 * @param availabilityDate the availabilityDate to set
	 */
	public void setAvailabilityDate(Date availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the publicationAt
	 */
	public Date getPublicationAt() {
		return publicationAt;
	}

	/**
	 * @param publicationAt the publicationAt to set
	 */
	public void setPublicationAt(Date publicationAt) {
		this.publicationAt = publicationAt;
	}

	/**
	 * @return the pictures
	 */
	public Map<String, String> getPictures() {
		return pictures;
	}

	/**
	 * @param pictures the pictures to set
	 */
	public void setPictures(Map<String, String> pictures) {
		this.pictures = pictures;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Platform [id=").append(id).append(", name=").append(name).append(", code=").append(code)
				.append(", manufacturer=").append(manufacturer).append(", developer=").append(developer)
				.append(", createdAt=").append(createdAt).append(", availabilityDate=").append(availabilityDate)
				.append(", createdBy=").append(createdBy).append(", publicationAt=").append(publicationAt)
				.append(", pictures=").append(pictures).append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availabilityDate == null) ? 0 : availabilityDate.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((developer == null) ? 0 : developer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pictures == null) ? 0 : pictures.hashCode());
		result = prime * result + ((publicationAt == null) ? 0 : publicationAt.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platform other = (Platform) obj;
		if (availabilityDate == null) {
			if (other.availabilityDate != null)
				return false;
		} else if (!availabilityDate.equals(other.availabilityDate))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (developer == null) {
			if (other.developer != null)
				return false;
		} else if (!developer.equals(other.developer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pictures == null) {
			if (other.pictures != null)
				return false;
		} else if (!pictures.equals(other.pictures))
			return false;
		if (publicationAt == null) {
			if (other.publicationAt != null)
				return false;
		} else if (!publicationAt.equals(other.publicationAt))
			return false;
		return true;
	}


}
