/**
 * 
 */
package com.gehc.apps.demo.dablog.model.post;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

/**
 * This is a class to manage Post to be published on the Blog.
 * 
 * @author Frederic Delorme
 *
 */
@Data
@ToString(includeFieldNames=true)
public class Post {

	@Id
	@NotNull
	private String id;

	private String uiid;

	@NotNull
	@Size(min = 1, max = 100)
	private String title;
	@NotNull
	private String type;

	@Size(min = 0, max = 400)
	private String header;
	@NotNull
	@Size(min = 1, max = 4000)
	private String content;

	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdAt;

	@CreatedBy
	private String createdBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date publicationAt;

	private PublicationState state;

	private Map<String, Object> metadata;
}
