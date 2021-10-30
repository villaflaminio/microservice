package com.flaminiovilla.security.controller;

import com.flaminiovilla.security.exception.BadRequestException;
import com.flaminiovilla.security.model.AuthProvider;
import com.flaminiovilla.security.model.User;
import com.flaminiovilla.security.model.dto.ApiResponseDto;
import com.flaminiovilla.security.model.dto.AuthResponseDto;
import com.flaminiovilla.security.model.dto.LoginRequestDto;
import com.flaminiovilla.security.model.dto.SignUpRequestDto;
import com.flaminiovilla.security.repository.UserRepository;
import com.flaminiovilla.security.security.TokenProvider;
import com.flaminiovilla.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;


    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        User user = authService.registerUser(signUpRequestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponseDto(true, "User registered successfully@"));
    }

}
