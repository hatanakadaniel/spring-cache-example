package com.hatanaka.cache.resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @GetMapping("/")
    @Cacheable(cacheNames = "teste")
    public String test() throws InterruptedException {
        Thread.sleep(5000);
        return "Ola Mundo";
    }
}
