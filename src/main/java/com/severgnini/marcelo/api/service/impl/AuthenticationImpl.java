package com.severgnini.marcelo.api.service.impl;

import com.severgnini.marcelo.api.model.Credentials;
import com.severgnini.marcelo.api.service.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthenticationImpl implements Authentication {

    // FIXME Change to configuration file or a database
    private static final Long TOKEN_VALID_INCREMENT_SECONDS = 43200L;
    private static final String ISSUER = "http://marcelo.severgnini.ddns.com";
    private static final String AUDIENCE = "http://marcelo.severgnini.ddns.com";
    private static final String REFRESH_COUNT = "refreshCount";
    private static final String REFRESH_LIMIT = "refreshLimit";
    private static final Integer TOKEN_REFRESH_LIMIT = 1;
    private static final Integer INITIAL_REFRESH_COUNTER = 0;
    private static final String SECRET_KEY = "HlIeW6LNi2RrHWpIsoYAZz36SxDnn3zpVhZcGoOda7TPh3tECj/1ob3qNbK6U/I8bFfRmWzJJmKWd8QfCRqIYg==";

    @Override
    public void authenticate(Credentials credentials) throws Exception {
        //TODO implement a database authentication
    }

    @Override
    public String issueToken(String username){

        String tokenIdentifier = generateIdentifier();
        ZonedDateTime issuedDate = ZonedDateTime.now();
        ZonedDateTime expirationDate = calculateExpirationDate(issuedDate);

        return issueJWTToken(username, tokenIdentifier, issuedDate, expirationDate);
    }

    private String generateIdentifier() {
        return UUID.randomUUID().toString();
    }

    private ZonedDateTime calculateExpirationDate(ZonedDateTime issuedDate) {
        return issuedDate.plusSeconds(TOKEN_VALID_INCREMENT_SECONDS);
    }

    private String issueJWTToken(String username, String tokenIdentifier, ZonedDateTime issuedDate, ZonedDateTime expirationDate){

        return Jwts.builder()
                .setId(tokenIdentifier)
                .setIssuer(ISSUER)
                .setAudience(AUDIENCE)
                .setSubject(username)
                .setIssuedAt(Date.from(issuedDate.toInstant()))
                .setExpiration(Date.from(expirationDate.toInstant()))
                .claim(REFRESH_COUNT, INITIAL_REFRESH_COUNTER)
                .claim(REFRESH_LIMIT, TOKEN_REFRESH_LIMIT)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}
