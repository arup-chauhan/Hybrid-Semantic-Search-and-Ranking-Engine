package com.hybrid.query.model;

public class QueryResult {
    private String message;
    private String solrResult;
    private String vectorResult;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getSolrResult() {
        return solrResult;
    }
    public void setSolrResult(String solrResult) {
        this.solrResult = solrResult;
    }

    public String getVectorResult() {
        return vectorResult;
    }
    public void setVectorResult(String vectorResult) {
        this.vectorResult = vectorResult;
    }
}
