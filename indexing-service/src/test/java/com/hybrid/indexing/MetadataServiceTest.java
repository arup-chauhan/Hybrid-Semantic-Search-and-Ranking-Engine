package com.hybrid.indexing;

import com.hybrid.indexing.service.MetadataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

class MetadataServiceTest {

    private JdbcTemplate jdbcTemplate;
    private MetadataService metadataService;

    @BeforeEach
    void setUp() {
        jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        metadataService = new MetadataService(jdbcTemplate);
    }

    @Test
    void testSaveMetadataInsertsRecord() {
        metadataService.saveMetadata("1", "Hybrid Search", "tech");

        verify(jdbcTemplate).update(
                eq("INSERT INTO document_metadata (id, title, category, indexed_at) VALUES (?, ?, ?, ?)"),
                eq("1"), eq("Hybrid Search"), eq("tech"), any(String.class)
        );
    }
}
