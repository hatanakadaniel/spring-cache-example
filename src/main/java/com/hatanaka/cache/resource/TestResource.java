package com.hatanaka.cache.resource;

import com.hatanaka.cache.service.StatementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestResource {

    private final StatementService statementService;

    @GetMapping("/")
    public String list() {
        log.info("m=list");
        return statementService.listAll();
    }

    @GetMapping("/insert/")
    public String insert() {
        log.info("m=insert");
        return statementService.save("12345678");
    }

    @GetMapping("/cache/")
    public String listFromCache() {
        log.info("m=listFromCache");
        return statementService.listFromCache("12345678");
    }

    @GetMapping("/clear/")
    public void clearCache() {
        log.info("m=clearCache");
        statementService.clearCache("12345678");
    }

    @GetMapping("/product2/")
    public ModelAndView product(ModelAndView modelAndView) {
        log.info("m=product2");
        modelAndView.setViewName("product");
        return modelAndView;
    }

}
