package com.hybridsearch.vector.controller;

import com.hybridsearch.vector.model.VectorResult;
import com.hybridsearch.vector.service.VectorSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vector")
public class VectorController {
    private final VectorSearchService vectorSearchService;

    public VectorController(VectorSearchService vectorSearchService) {
        this.vectorSearchService = vectorSearchService;
    }

    @GetMapping("/search")
    public List<VectorResult> search(@RequestParam String query) {
        return vectorSearchService.search(query);
    }
}
