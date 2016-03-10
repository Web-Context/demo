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