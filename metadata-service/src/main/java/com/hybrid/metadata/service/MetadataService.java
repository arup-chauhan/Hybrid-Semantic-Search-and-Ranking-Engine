package com.hybrid.metadata.service;

import com.hybrid.metadata.model.MetadataRecord;
import com.hybrid.metadata.repository.MetadataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataService {
    private final MetadataRepository repository;

    public MetadataService(MetadataRepository repository) {
        this.repository = repository;
    }

    public MetadataRecord save(MetadataRecord record) {
        return repository.save(record);
    }

    public MetadataRecord getByDocumentId(String id) {
        return repository.findByDocumentId(id);
    }

    public List<MetadataRecord> getAll() {
        return repository.findAll();
    }
}
