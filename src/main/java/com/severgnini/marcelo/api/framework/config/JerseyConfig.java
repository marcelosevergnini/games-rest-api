package com.severgnini.marcelo.api.framework.config;

import com.severgnini.marcelo.api.framework.security.filter.AuthenticationFilter;
import com.severgnini.marcelo.api.framework.security.filter.AuthorizationFilter;
import com.severgnini.marcelo.api.rest.GamesResource;
import com.severgnini.marcelo.api.rest.authentication.AuthenticationResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfig  extends ResourceConfig{

    public JerseyConfig(){
        registerFilters();
    }

    private void registerFilters(){

        register(AuthenticationResource.class);
        register(AuthenticationFilter.class);
        register(AuthorizationFilter.class);
        register(GamesResource.class);
    }

}
