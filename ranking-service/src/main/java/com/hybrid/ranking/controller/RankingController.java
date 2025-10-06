package com.hybridsearch.ranking.controller;

import com.hybridsearch.ranking.model.RankedDocument;
import com.hybridsearch.ranking.service.RankingService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/rank")
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping
    public List<RankedDocument> rankDocuments(@RequestBody List<Map<String, Object>> docs) {
        return rankingService.rank(docs);
    }
}
