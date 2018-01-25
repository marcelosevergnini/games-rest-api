package com.severgnini.marcelo.api.framework.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.severgnini.marcelo.api.framework")
public class SpringBootJaxrsApplication {

    public static void main(String... args){
        SpringApplication.run(SpringBootJaxrsApplication.class, args);
    }
}
