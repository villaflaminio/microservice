package com.flaminiovilla.security.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SwaggerController {
    @RequestMapping("/doc/security-oauth2-service")
    public String greeting() {
        return "redirect:/swagger-ui.html";
    }
}
