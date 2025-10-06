package com.hybrid.query.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SolrClientService {

    private final WebClient webClient;

    public SolrClientService(@Value("${solr.url}") String solrUrl) {
        this.webClient = WebClient.builder().baseUrl(solrUrl).build();
    }

    public String search(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/select")
                        .queryParam("q", query)
                        .queryParam("wt", "json")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
