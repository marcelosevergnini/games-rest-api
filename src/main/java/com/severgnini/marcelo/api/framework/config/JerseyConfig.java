package com.severgnini.marcelo.api.framework.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig  extends ResourceConfig{

    @Autowired
    public JerseyConfig(){
        packages("com.severgnini.marcelo.api.framework.rest");
    }

}
