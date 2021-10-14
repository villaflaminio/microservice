package com.flaminiovilla.bookshare.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {
    @RequestMapping("/doc/book-share-service")
    public String greeting() {
        return "redirect:/swagger-ui.html";
    }
}
