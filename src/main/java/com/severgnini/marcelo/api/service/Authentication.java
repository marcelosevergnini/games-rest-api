package com.severgnini.marcelo.api.service;

import com.severgnini.marcelo.api.model.Credentials;

public interface Authentication {

    void authenticate(Credentials credentials) throws Exception;

    String issueToken(String username) throws Exception;

}
