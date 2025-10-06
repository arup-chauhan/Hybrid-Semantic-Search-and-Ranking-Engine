package com.hybrid.indexing;

import com.hybrid.indexing.consumer.DocumentConsumer;
import com.hybrid.indexing.service.SolrIndexService;
import com.hybrid.indexing.service.MetadataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DocumentConsumerTest {

    private SolrIndexService solrIndexService;
    private MetadataService metadataService;
    private DocumentConsumer documentConsumer;

    @BeforeEach
    void setUp() {
        solrIndexService = Mockito.mock(SolrIndexService.class);
        metadataService = Mockito.mock(MetadataService.class);
        documentConsumer = new DocumentConsumer(solrIndexService, metadataService);
    }

    @Test
    void testConsumeCallsBothServices() {
        String message = "{\"id\":\"1\",\"title\":\"Hybrid Search\",\"metadata\":\"tech\"}";

        documentConsumer.consume(message);

        Mockito.verify(solrIndexService).indexDocument(message);
        Mockito.verify(metadataService).saveMetadata(Mockito.eq("1"), Mockito.eq("Hybrid Search"), Mockito.eq("tech"));
    }
}
