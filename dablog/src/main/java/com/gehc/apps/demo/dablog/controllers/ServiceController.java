package com.gehc.apps.demo.dablog.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gehc.apps.demo.dablog.model.platform.Platform;
import com.gehc.apps.demo.dablog.model.post.Post;
import com.gehc.apps.demo.dablog.services.DataSetReader;

@RestController
@RequestMapping("service")
public class ServiceController {

	@Autowired
	DataSetReader<Post> postDatasetReader;
	@Autowired
	DataSetReader<Platform> platformDatasetReader;

	@RequestMapping("reload")
	public void reload(HttpServletResponse response) {
		try {
			platformDatasetReader.importData("dataset/platform.json", Platform.class, true, true);
			postDatasetReader.importData("dataset/post.json", Post.class, true, true);
			response.setStatus(200);
		} catch (Exception e) {
			response.setStatus(2015);
		}

	}

}