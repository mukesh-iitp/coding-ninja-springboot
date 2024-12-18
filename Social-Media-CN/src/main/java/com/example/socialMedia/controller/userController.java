package com.example.socialMedia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.socialMedia.model.Connection;
import com.example.socialMedia.repository.ConnectionDal;
import com.example.socialMedia.service.ConnectionService;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/ninjas")
public class userController {
	
	Logger logger = LoggerFactory.getLogger(userController.class);
	
	@Autowired
	ConnectionService connectionService;
	
	@Autowired
	ConnectionDal connectionDao;
	
	@GetMapping("/test")
	@Timed("test.api")
	public String test() {
		return "dev tools test success!";
	}
	
	@GetMapping("/test2")
	@Timed("test.api2")
	public String test2() {
		return "live reload test success!";
	}
	
	@GetMapping("/connections")
	@Timed(value="getConnections.api")
	public List<Connection> getConnections() {
		logger.info("Starting to get connections!");
		logger.trace("Starting get connections: level = TRACE");
		
		List<Connection> responseConnections =  connectionService.getConnections();
		
		logger.info("Response: " + responseConnections);
		return responseConnections;
	}
	
	@GetMapping("/connections/{company}")
	public List<Connection> getConnectionsByCompany(@PathVariable String company){
		List<Connection> reConnections =  connectionService.getConnectionsByCompany(company);
		try {
			if(reConnections.isEmpty())
				throw new Exception();
		}catch (Exception e) {
			logger.error("Exception: Received an empty response!");
		}
		return reConnections;
	}
	
	@PostMapping("/add")
	public Connection addConnection(@RequestBody Connection connection) {
		return connectionService.addConnection(connection);
	}
	
}
