package com.flaminiovilla.bookshare.security.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    public String email;
    public String password;
    public String role;
}