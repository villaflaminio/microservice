package com.flaminiovilla.bookshare;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Log4j2
@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
public class BookShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShareApplication.class, args);


    }

    @Component
    public class Runner implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            log.info("Log4j2 logger works!");

        }
    }
}
