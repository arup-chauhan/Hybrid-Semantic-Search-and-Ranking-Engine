package com.hybrid.monitoring.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusConfig {
    public PrometheusConfig(MeterRegistry registry) {
        registry.config().commonTags("application", "monitoring-service");
    }
}
