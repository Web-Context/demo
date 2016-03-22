/**
 * 
 */
package com.gehc.apps.demo.dablog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gehc.apps.demo.dablog.bootstrap.DataBootstrap;

/**
 * DaBlogApp, the main application class.
 * 
 * @author Frederic Delorme
 *
 */
@SpringBootApplication
public class DaBlogApp {

	@Autowired
	DataBootstrap injector;

	public static void main(String[] args) {
		SpringApplication.run(DaBlogApp.class, args);

	}
}
