package com.severgnini.marcelo.api.model;

import java.io.Serializable;

public class Token implements Serializable{

    private static final long serialVersionUID = 8645490143603833396L;

    private String token;

    public Token(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
