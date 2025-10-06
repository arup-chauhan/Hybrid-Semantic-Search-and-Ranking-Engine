package com.hybrid.aggregation.model;

import java.util.Map;

public class AggregatedResult {
    private Map<String, Double> results;

    public AggregatedResult(Map<String, Double> results) {
        this.results = results;
    }

    public Map<String, Double> getResults() {
        return results;
    }

    public void setResults(Map<String, Double> results) {
        this.results = results;
    }
}
