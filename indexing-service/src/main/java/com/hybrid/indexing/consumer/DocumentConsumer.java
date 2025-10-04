package com.hybrid.indexing.consumer;

import com.hybrid.indexing.service.SolrIndexService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DocumentConsumer {

    private final SolrIndexService solrIndexService;

    public DocumentConsumer(SolrIndexService solrIndexService) {
        this.solrIndexService = solrIndexService;
    }

    @KafkaListener(topics = "ingestion-topic", groupId = "indexing-group")
    public void consume(String message) {
        solrIndexService.indexDocument(message);
    }
}
