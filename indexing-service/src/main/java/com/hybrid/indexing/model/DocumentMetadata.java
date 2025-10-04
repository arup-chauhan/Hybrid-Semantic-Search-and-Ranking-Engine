package com.hybrid.indexing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_metadata")
public class DocumentMetadata {

    @Id
    private String id;
    private String title;
    private String category;
    private String indexedAt;

    public DocumentMetadata() {}

    public DocumentMetadata(String id, String title, String category, String indexedAt) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.indexedAt = indexedAt;
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getIndexedAt() { return indexedAt; }
    public void setIndexedAt(String indexedAt) { this.indexedAt = indexedAt; }
}
