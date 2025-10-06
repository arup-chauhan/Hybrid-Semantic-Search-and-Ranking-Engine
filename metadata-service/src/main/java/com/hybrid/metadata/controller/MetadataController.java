package com.hybrid.metadata.controller;

import com.hybrid.metadata.model.MetadataRecord;
import com.hybrid.metadata.service.MetadataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metadata")
public class MetadataController {
    private final MetadataService service;

    public MetadataController(MetadataService service) {
        this.service = service;
    }

    @PostMapping
    public MetadataRecord save(@RequestBody MetadataRecord record) {
        return service.save(record);
    }

    @GetMapping("/{documentId}")
    public MetadataRecord getById(@PathVariable String documentId) {
        return service.getByDocumentId(documentId);
    }

    @GetMapping
    public List<MetadataRecord> getAll() {
        return service.getAll();
    }
}
