package com.hatanaka.cache.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ProductResource {

    @GetMapping("/product/")
    public String product(Model model) {
        log.info("m=product");
        model.addAttribute("teste", "teste");
        return "product";
    }
}
