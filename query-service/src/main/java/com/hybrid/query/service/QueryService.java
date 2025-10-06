package com.hybrid.query.service;

import com.hybrid.query.model.QueryRequest;
import com.hybrid.query.model.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    @Autowired
    private SolrClientService solrClient;

    @Autowired
    private VectorClientService vectorClient;

    public QueryResult executeHybridSearch(QueryRequest request) {
        // Call Solr
        String solrResponse = solrClient.search(request.getQuery());

        // Call Vector Service
        String vectorResponse = vectorClient.search(request.getQuery());

        // TODO: Merge and apply ranking logic
        QueryResult result = new QueryResult();
        result.setMessage("Hybrid result from Solr + Vector search");
        result.setSolrResult(solrResponse);
        result.setVectorResult(vectorResponse);

        return result;
    }
}
