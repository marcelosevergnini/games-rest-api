package com.severgnini.marcelo.api.models;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Credentials implements Serializable {

    private static final long serialVersionUID = -300944377814130261L;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
