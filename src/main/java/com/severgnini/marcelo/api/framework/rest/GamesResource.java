package com.severgnini.marcelo.api.framework.rest;

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
    @Path("all")
    public Response getAll(){
        return Response.ok().entity(new StringBuilder("Hello World, Working fine!!").toString()).build();
    }

}
