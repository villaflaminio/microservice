package com.flaminiovilla.bookshare.security.service;

import com.flaminiovilla.bookshare.model.Profile;
import com.flaminiovilla.bookshare.security.SecurityUtils;
import com.flaminiovilla.bookshare.security.exception.UserException;
import com.flaminiovilla.bookshare.security.model.Authority;
import com.flaminiovilla.bookshare.security.model.User;
import com.flaminiovilla.bookshare.security.repository.AuthorityRepository;
import com.flaminiovilla.bookshare.security.repository.UserRepository;
import com.flaminiovilla.bookshare.security.rest.dto.RegisterDTO;
import com.flaminiovilla.bookshare.service.ProfileService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static com.flaminiovilla.bookshare.security.exception.UserException.userExceptionCode.AUTHORITY_NOT_EXIST;
import static com.flaminiovilla.bookshare.security.exception.UserException.userExceptionCode.USER_ALREADY_EXISTS;

@Service
@Transactional
public class UserService {
   @Autowired
   private PasswordEncoder bcryptEncoder;
   @Autowired
   private ProfileService profileService;
   @Autowired
   AuthorityRepository authorityRepository;

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional(readOnly = true)
   public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByEmail);
   }
   public void ceckUser(RegisterDTO registerDTO) {
      Preconditions.checkArgument(Objects.nonNull(registerDTO.email));
      Preconditions.checkArgument(Objects.nonNull(registerDTO.password));
      Preconditions.checkArgument(Objects.nonNull(registerDTO.firstName));
      Preconditions.checkArgument(Objects.nonNull(registerDTO.lastName));

   }

   public User register(RegisterDTO registerDTO) {
      registerDTO.role = "USER";
      ceckUser(registerDTO);
      if (!userRepository.existsByEmail(registerDTO.email) ) {
         User newUser = userRepository.save(User.builder()
                 .email(registerDTO.email)
                 .password(bcryptEncoder.encode(registerDTO.password))
                 .activated(true)
                 .authorities(role(registerDTO))
                 .build());

         registerDTO.user = newUser;
         Profile newProfile =profileService.saveProfile(registerDTO);
         newUser.setUserProfile(newProfile);
         return userRepository.save(newUser);
      }
      throw new UserException(USER_ALREADY_EXISTS);
   }

   private Set<Authority> role(RegisterDTO registerDTO) {
      Set<Authority> author = new HashSet<>();
      if (registerDTO.role.equals("USER")) {
         author.add(authorityRepository.getByName("USER"));
      } else if (registerDTO.role.equals("ADMIN")) {
         author.add(authorityRepository.getByName("USER"));
         author.add(authorityRepository.getByName("ADMIN"));
      } else {
         throw new UserException(AUTHORITY_NOT_EXIST);
      }
      return author;
   }
}
