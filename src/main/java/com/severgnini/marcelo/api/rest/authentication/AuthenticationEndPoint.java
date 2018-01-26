package com.severgnini.marcelo.api.rest.authentication;

import com.severgnini.marcelo.api.models.Credentials;
import com.severgnini.marcelo.api.services.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationEndPoint {


    @Autowired
    private Authentication authentication;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(@RequestBody Credentials credentials) {

        try {

            authenticate(credentials);

            String token = issueToken(credentials.getUsername());

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(Credentials credentials) throws Exception {
        authentication.authenticate(credentials);
    }

    private String issueToken(String username) throws Exception{
        return authentication.createJWT(username);
    }

}
