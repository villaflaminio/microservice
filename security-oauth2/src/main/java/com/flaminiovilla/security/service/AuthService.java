package com.flaminiovilla.security.service;

import com.flaminiovilla.security.exception.BadRequestException;
import com.flaminiovilla.security.model.AuthProvider;
import com.flaminiovilla.security.model.User;
import com.flaminiovilla.security.model.dto.SignUpRequestDto;
import com.flaminiovilla.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(SignUpRequestDto signUpRequestDto){
        if(userRepository.existsByEmail(signUpRequestDto.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequestDto.getName());
        user.setEmail(signUpRequestDto.getEmail());
        user.setPassword(signUpRequestDto.getPassword());
        user.setProvider(AuthProvider.local);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
