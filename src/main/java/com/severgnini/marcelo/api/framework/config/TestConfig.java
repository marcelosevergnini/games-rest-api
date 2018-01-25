package com.severgnini.marcelo.api.framework.config;

import com.severgnini.marcelo.api.framework.rest.GamesResource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = GamesResource.class)
public class TestConfig {
}