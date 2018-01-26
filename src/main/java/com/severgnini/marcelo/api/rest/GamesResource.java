package com.severgnini.marcelo.api.rest;

import com.severgnini.marcelo.api.framework.config.security.annotations.Secured;
import com.severgnini.marcelo.api.framework.config.security.enums.Role;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GamesResource {

    @GET
    @Path("up")
    public Response isUp(){
        return Response.ok().entity(new StringBuilder("Hello World, Working fine!!").toString()).build();
    }

    @GET
    @Path("all")
    @Secured({Role.USER})
    public Response getAll(){
        return Response.ok().entity(new StringBuilder("Hello World, Working fine!!").toString()).build();
    }

}


