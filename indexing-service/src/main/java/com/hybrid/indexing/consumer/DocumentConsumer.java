package com.hybrid.indexing.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hybrid.indexing.service.SolrIndexService;
import com.hybrid.indexing.service.MetadataService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DocumentConsumer {

    private final SolrIndexService solrIndexService;
    private final MetadataService metadataService;
    private final ObjectMapper mapper = new ObjectMapper();

    public DocumentConsumer(SolrIndexService solrIndexService, MetadataService metadataService) {
        this.solrIndexService = solrIndexService;
        this.metadataService = metadataService;
    }

    @KafkaListener(topics = "ingestion-topic", groupId = "indexing-group")
    public void consume(String message) {
        solrIndexService.indexDocument(message);
        try {
            JsonNode node = mapper.readTree(message);
            metadataService.saveMetadata(
                    node.path("id").asText(),
                    node.path("title").asText(),
                    node.path("metadata").asText()
            );
        } catch (Exception ignored) {}
    }
}
