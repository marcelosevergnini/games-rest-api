package com.severgnini.marcelo.api.services.impl;

import com.severgnini.marcelo.api.models.Credentials;
import com.severgnini.marcelo.api.services.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.util.Date;

@Service
public class AuthenticationImpl implements Authentication {

    private KeyGenerator keyGenerator;

    @Override
    public void authenticate(Credentials credentials) throws Exception {
        //TODO implement a database authentications
    }

    @Override
    public String createJWT(String username){
        Key key = keyGenerator.generateKey();
        return Jwts.builder()
                .setSubject(username)
//                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
//                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}
