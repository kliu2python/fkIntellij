package com.example.springmvctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringMvcTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcTemplateApplication.class, args);
    }
}
