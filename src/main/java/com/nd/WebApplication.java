package com.nd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nd.**")
public class WebApplication extends SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
