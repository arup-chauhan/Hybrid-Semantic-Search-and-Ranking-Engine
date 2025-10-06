package com.hybrid.aggregation.service;

import com.hybrid.aggregation.model.AggregatedResult;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AggregationService {

    public AggregatedResult aggregate(Map<String, Double> rankingResults, Map<String, Double> vectorResults) {
        Map<String, Double> merged = new HashMap<>();

        rankingResults.forEach((doc, score) -> merged.put(doc, score * 0.6));
        vectorResults.forEach((doc, score) ->
                merged.merge(doc, score * 0.4, Double::sum));

        List<Map.Entry<String, Double>> sorted = new ArrayList<>(merged.entrySet());
        sorted.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        LinkedHashMap<String, Double> finalResults = new LinkedHashMap<>();
        sorted.forEach(e -> finalResults.put(e.getKey(), e.getValue()));

        return new AggregatedResult(finalResults);
    }
}
