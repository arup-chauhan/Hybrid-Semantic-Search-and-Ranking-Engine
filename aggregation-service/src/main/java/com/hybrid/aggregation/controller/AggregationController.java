package com.hybrid.aggregation.controller;

import com.hybrid.aggregation.model.AggregatedResult;
import com.hybrid.aggregation.service.AggregationService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/aggregate")
public class AggregationController {

    private final AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @PostMapping
    public AggregatedResult aggregate(@RequestBody Map<String, Map<String, Double>> payload) {
        Map<String, Double> rankingResults = payload.get("ranking");
        Map<String, Double> vectorResults = payload.get("vector");
        return aggregationService.aggregate(rankingResults, vectorResults);
    }
}
