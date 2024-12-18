package com.example.socialMedia.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.example.socialMedia.repository.ConnectionDal;

@Component
public class DatabaseMonitoringService implements HealthIndicator {
	
	private final String DATABASE_NAME = "Connections Database";
	
	@Autowired
	ConnectionDal connectionDal;

	@Override
	public Health health() {
		if(isDatabaseHealthy())
			return Health.up().withDetail(DATABASE_NAME, "is up and running!").build();
		return Health.down().withDetail(DATABASE_NAME, "is down and not working!").build();
	}

	private boolean isDatabaseHealthy() {
		try {
			connectionDal.findById(1);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
