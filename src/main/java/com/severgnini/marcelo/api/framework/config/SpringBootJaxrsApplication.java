package com.severgnini.marcelo.api.framework.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootJaxrsApplication {

    public static void main(String... args){
        SpringApplication.run(SpringBootJaxrsApplication.class, args);
    }
}
