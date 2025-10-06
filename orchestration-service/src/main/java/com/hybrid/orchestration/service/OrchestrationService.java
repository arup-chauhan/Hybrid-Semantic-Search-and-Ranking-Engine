package com.hybrid.orchestration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrchestrationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void executeWorkflow() {
        restTemplate.postForObject("http://ingestion-service/ingest/start", null, String.class);
        restTemplate.postForObject("http://indexing-service/index/start", null, String.class);
        restTemplate.postForObject("http://query-service/query/refresh", null, String.class);
        restTemplate.postForObject("http://ranking-service/rank/update", null, String.class);
    }
}
