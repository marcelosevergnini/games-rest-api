package com.severgnini.marcelo.api.framework.config;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig  extends ResourceConfig{

    public JerseyConfig(){
        packages("com.severgnini.marcelo.api.framework.service");
    }
}
