package com.hybrid.indexing.service;

import com.hybrid.indexing.model.DocumentMetadata;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MetadataService {

    private final JdbcTemplate jdbcTemplate;

    public MetadataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveMetadata(String id, String title, String category) {
        String sql = "INSERT INTO document_metadata (id, title, category, indexed_at) VALUES (?, ?, ?, ?)";
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        jdbcTemplate.update(sql, id, title, category, now);
    }
}
