package com.example.socialMedia.monitoring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;

@Configuration
public class MetricConfiguration {

	@Bean
	public MeterRegistry getMeterRegistry() {
		
		CompositeMeterRegistry meterRegistry = new CompositeMeterRegistry();
		return meterRegistry;
	}
}
