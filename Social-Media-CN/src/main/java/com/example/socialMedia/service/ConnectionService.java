package com.example.socialMedia.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMedia.controller.userController;
import com.example.socialMedia.model.Connection;
import com.example.socialMedia.repository.ConnectionDal;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;

@Service
public class ConnectionService {
	
	private Counter connectionCallCounter = null;
	
	public ConnectionService(CompositeMeterRegistry meterRegistry) {
		connectionCallCounter = meterRegistry.counter("connection.call.counter");
	}
	
	Logger logger = LoggerFactory.getLogger(ConnectionService.class);

	@Autowired
	ConnectionDal connectionDal;
	
	public List<Connection> getConnections() {
		logger.trace("Starting connection service: level = TRACE");
		logger.info("Starting connection service: level = INFO");
		connectionCallCounter.increment();
		return connectionDal.findAll();
	}

	public List<Connection> getConnectionsByCompany(String company) {
		return connectionDal.findByCompany(company);
	}

	public Connection addConnection(Connection connection) {
		return connectionDal.save(connection);
	}

}
