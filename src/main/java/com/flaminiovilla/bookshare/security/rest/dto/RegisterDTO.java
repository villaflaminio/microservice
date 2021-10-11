package com.flaminiovilla.bookshare.security.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flaminiovilla.bookshare.security.model.User;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterDTO {
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public Date birthday;
    public String phoneNumber;
    public String role;
    public User user;
}
