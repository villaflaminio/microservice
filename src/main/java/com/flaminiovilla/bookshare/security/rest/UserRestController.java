package com.flaminiovilla.bookshare.security.rest;

import com.flaminiovilla.bookshare.security.helper.UserHelper;
import com.flaminiovilla.bookshare.security.model.User;
import com.flaminiovilla.bookshare.security.rest.dto.LoginDTO;
import com.flaminiovilla.bookshare.security.rest.dto.RegisterDTO;
import com.flaminiovilla.bookshare.security.rest.dto.UserDTO;
import com.flaminiovilla.bookshare.security.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

   @Autowired
   UserHelper userHelper;

   @Autowired
   UserService userService;
   /***
    * Login to the application
    * @param loginDto
    * @return
    */
   @PostMapping("/signIn")
   @ApiOperation(notes = "Return token",
           value = "JWTToken")
   public ResponseEntity<UserHelper.JWTToken> authorize(@Valid @RequestBody LoginDTO loginDto) {
      return userHelper.authorize(loginDto);
   }

   /***
    * Register to the application
    * {
    *
    * }
    * @param
    * @return
    */
   @PostMapping("/signUp")
   public User signUp( @RequestBody RegisterDTO registerDTO) {
      return userService.register(registerDTO);
   }

}
