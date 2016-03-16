package com.gehc.apps.demo.dablog.model.platform;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a class to manage game execution platform.
 *
 *
 * here a sample entity from json mongodb doc. { "name" : "Microsoft Xbox 360",
 * "accesskey" : "X", "availabilityDate" : "2005-11-22 00:00:00", "manufacturer"
 * : "Flextronics, Wistron, Celestica, Foxconn", "createdAt" :
 * "2015-07-01 16:48:23", "code" : "x360", "developer" : "Microsoft", "pictures"
 * : { "big" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL1000_.jpg",
 * "medium" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL500_.jpg",
 * "small" : "http://ecx.images-amazon.com/images/I/41God7KwSOL._SL250_.jpg" }
 * 
 * @author Frederic Delorme
 *
 */
@Document(collection = "platforms")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
