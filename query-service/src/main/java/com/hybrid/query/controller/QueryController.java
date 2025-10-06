package com.hybrid.query.controller;

import com.hybrid.query.model.QueryRequest;
import com.hybrid.query.model.QueryResult;
import com.hybrid.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping
    public QueryResult search(@RequestBody QueryRequest request) {
        return queryService.executeHybridSearch(request);
    }
}
