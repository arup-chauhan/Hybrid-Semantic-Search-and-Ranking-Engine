package com.hybrid.query;

import com.hybrid.query.model.QueryRequest;
import com.hybrid.query.service.QueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QueryServiceTests {

    @Autowired
    private QueryService queryService;

    @Test
    void contextLoads() {
        assertThat(queryService).isNotNull();
    }

    @Test
    void testHybridSearch() {
        QueryRequest req = new QueryRequest();
        req.setQuery("test");
        assertThat(queryService.executeHybridSearch(req)).isNotNull();
    }
}
