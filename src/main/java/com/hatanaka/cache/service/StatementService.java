package com.hatanaka.cache.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatementService {

    private final CacheManager cacheManager;

    public String listAll() {
        return "Statement without cache";
    }

    @Cacheable(value = "teste", key = "#statement", sync = true)
    public String listFromCache(final String statement) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Stament from Cache Method";
    }

    @CachePut(value = "teste", key = "#statement")
    public String save(final String statement) {
        return statement;
    }

    @CacheEvict(value = "teste", key = "#statement")
    public void clearCache(final String statement) {

    }
}
