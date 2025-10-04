package com.hybrid.indexing.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@Service
public class SolrIndexService {

    private final SolrClient solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/hybrid_core").build();
    private final ObjectMapper mapper = new ObjectMapper();

    public void indexDocument(String message) {
        try {
            Map<String, Object> docMap = mapper.readValue(message, Map.class);
            SolrInputDocument doc = new SolrInputDocument();
            docMap.forEach(doc::addField);
            solrClient.add(doc);
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
