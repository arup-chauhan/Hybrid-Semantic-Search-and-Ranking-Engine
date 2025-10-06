package com.hybrid.monitoring.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final MeterRegistry registry;

    public MetricsService(MeterRegistry registry) {
        this.registry = registry;
    }

    public void recordGatewayRequest() {
        registry.counter("gateway_requests_total").increment();
    }
}
