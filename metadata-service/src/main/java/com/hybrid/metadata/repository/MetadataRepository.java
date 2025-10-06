package com.hybrid.metadata.repository;

import com.hybrid.metadata.model.MetadataRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<MetadataRecord, Long> {
    MetadataRecord findByDocumentId(String documentId);
}
