package com.hybrid.caching;

import com.hybrid.caching.service.CacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CacheServiceTest {

    private RedisTemplate<String, Object> redisTemplate;
    private ValueOperations<String, Object> valueOps;
    private CacheService cacheService;

    @BeforeEach
    void setUp() {
        redisTemplate = mock(RedisTemplate.class);
        valueOps = mock(ValueOperations.class);
        when(redisTemplate.opsForValue()).thenReturn(valueOps);
        cacheService = new CacheService(redisTemplate);
    }

    @Test
    void testPut() {
        doNothing().when(valueOps).set("key", "value", 60, TimeUnit.SECONDS);
        cacheService.put("key", "value", 60);
        verify(valueOps, times(1)).set("key", "value", 60, TimeUnit.SECONDS);
    }

    @Test
    void testGet() {
        when(valueOps.get("key")).thenReturn("cachedValue");
        Object result = cacheService.get("key");
        assertEquals("cachedValue", result);
    }

    @Test
    void testEvict() {
        doNothing().when(redisTemplate).delete("key");
        cacheService.evict("key");
        verify(redisTemplate, times(1)).delete("key");
    }
}
