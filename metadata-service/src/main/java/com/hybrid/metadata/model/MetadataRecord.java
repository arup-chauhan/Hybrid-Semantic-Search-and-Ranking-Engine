package com.hybrid.metadata.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "metadata_records")
public class MetadataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentId;
    private String source;
    private String version;
    private Instant createdAt = Instant.now();

    // Getters and setters
    public Long getId() { return id; }
    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public Instant getCreatedAt() { return createdAt; }
}
