package com.hybrid.caching.controller;

import com.hybrid.caching.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/put")
    public String put(@RequestParam String key, @RequestBody Object value, @RequestParam long ttl) {
        cacheService.put(key, value, ttl);
        return "Cached successfully";
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        return cacheService.get(key);
    }

    @DeleteMapping("/evict")
    public String evict(@RequestParam String key) {
        cacheService.evict(key);
        return "Key evicted";
    }
}
