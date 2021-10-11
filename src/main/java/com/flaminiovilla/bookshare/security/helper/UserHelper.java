package com.flaminiovilla.bookshare.security.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flaminiovilla.bookshare.repository.ProfileRepository;
import com.flaminiovilla.bookshare.security.exception.UserException;
import com.flaminiovilla.bookshare.security.jwt.JWTFilter;
import com.flaminiovilla.bookshare.security.jwt.TokenProvider;
import com.flaminiovilla.bookshare.security.model.Authority;
import com.flaminiovilla.bookshare.security.model.User;
import com.flaminiovilla.bookshare.security.repository.AuthorityRepository;
import com.flaminiovilla.bookshare.security.repository.UserRepository;
import com.flaminiovilla.bookshare.security.rest.dto.LoginDTO;
import com.flaminiovilla.bookshare.security.rest.dto.RegisterDTO;
import com.flaminiovilla.bookshare.security.rest.dto.UserDTO;
import com.flaminiovilla.bookshare.service.ProfileService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.flaminiovilla.bookshare.security.exception.UserException.userExceptionCode.AUTHORITY_NOT_EXIST;
import static com.flaminiovilla.bookshare.security.exception.UserException.userExceptionCode.USER_ALREADY_EXISTS;

@Component
public class UserHelper {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    private ProfileService profileService;

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserHelper(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginDTO loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        //SecurityContextHolder è una classe di supporto, che forniscono l'accesso al contesto di protezione
        SecurityContextHolder.getContext().setAuthentication(authentication);

        boolean rememberMe = (loginDto.rememberMe == null) ? false : loginDto.isRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    public static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }




}
