package com.severgnini.marcelo.api.rest.authentication;

import com.severgnini.marcelo.api.model.Credentials;
import com.severgnini.marcelo.api.model.Token;
import com.severgnini.marcelo.api.service.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    @Autowired
    private Authentication authenticationService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response authenticateUser(@RequestBody Credentials credentials) {

        try {

            authenticate(credentials);

            String issuedToken = issueToken(credentials.getUsername());
            Token token = new Token(issuedToken);

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(Credentials credentials) throws Exception {
        authenticationService.authenticate(credentials);
    }

    private String issueToken(String username) throws Exception{
        return authenticationService.issueToken(username);
    }

}
