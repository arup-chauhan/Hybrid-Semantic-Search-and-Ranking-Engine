package com.hybridsearch.fusion.controller;

import com.hybridsearch.fusion.model.FusionResponse;
import com.hybridsearch.fusion.service.FusionService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/fusion")
public class FusionController {
    private final FusionService fusionService;

    public FusionController(FusionService fusionService) {
        this.fusionService = fusionService;
    }

    @PostMapping("/combine")
    public FusionResponse combineResults(@RequestBody Map<String, Object> payload) {
        return fusionService.fuseResults(payload);
    }
}
