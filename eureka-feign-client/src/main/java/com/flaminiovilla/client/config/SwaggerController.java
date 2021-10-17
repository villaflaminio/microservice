package com.flaminiovilla.client.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {
    @RequestMapping("/doc/client")
    public String greeting() {
        return "redirect:/swagger-ui.html";
    }
}
