package com.hybrid.aggregation;

import com.hybrid.aggregation.controller.AggregationController;
import com.hybrid.aggregation.model.AggregatedResult;
import com.hybrid.aggregation.service.AggregationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AggregationController.class)
class AggregationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AggregationService aggregationService;

    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    void testAggregateEndpointReturnsMergedResults() throws Exception {
        Map<String, Double> ranking = Map.of("doc1", 0.9);
        Map<String, Double> vector = Map.of("doc1", 0.8);
        Map<String, Double> merged = Map.of("doc1", 0.86);

        when(aggregationService.aggregate(ranking, vector))
                .thenReturn(new AggregatedResult(merged));

        Map<String, Map<String, Double>> payload = Map.of("ranking", ranking, "vector", vector);

        mockMvc.perform(post("/aggregate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(payload)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results.doc1").value(0.86));
    }
}
