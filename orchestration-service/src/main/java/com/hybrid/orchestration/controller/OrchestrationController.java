package com.hybrid.orchestration.controller;

import com.hybrid.orchestration.service.OrchestrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orchestrate")
public class OrchestrationController {

    private final OrchestrationService service;

    public OrchestrationController(OrchestrationService service) {
        this.service = service;
    }

    @PostMapping("/trigger")
    public String triggerFlow() {
        service.executeWorkflow();
        return "Orchestration workflow triggered successfully.";
    }
}
