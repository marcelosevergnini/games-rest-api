package com.severgnini.marcelo.api.services;

import com.severgnini.marcelo.api.models.Credentials;

public interface Authentication {

    void authenticate(Credentials credentials) throws Exception;

    String createJWT(String username) throws Exception;

}
