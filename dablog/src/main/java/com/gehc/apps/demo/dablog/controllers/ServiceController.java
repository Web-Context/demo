package com.gehc.apps.demo.dablog.controllers;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gehc.apps.demo.dablog.bootstrap.DataSetReader;
import com.gehc.apps.demo.dablog.model.platform.Platform;
import com.gehc.apps.demo.dablog.model.post.Post;

@RestController
@RequestMapping("service")
public class ServiceController {

	@Autowired
	DataSetReader<Post> postDatasetReader;
	@Autowired
	DataSetReader<Platform> platformDatasetReader;

	@RequestMapping("/reload")
	@Produces(value = "application/json")
	public Response foo() {
		try {
			platformDatasetReader.importData("dataset/platform.json", Platform.class, true, true);
			postDatasetReader.importData("dataset/post.json", Post.class, true, true);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.RESET_CONTENT).build();
		}
	}

}