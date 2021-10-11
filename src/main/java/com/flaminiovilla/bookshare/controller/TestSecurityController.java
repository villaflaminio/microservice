package com.flaminiovilla.bookshare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestSecurityController {

   @GetMapping("/testUser")
   public ResponseEntity<String> user() {
      return ResponseEntity.ok("UTENTE");
   }


   @GetMapping("/testAdmin")
   public ResponseEntity<String> admin() {
      return ResponseEntity.ok("ADMIN");
   }

}
