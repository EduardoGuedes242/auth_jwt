package com.eduardoguedes.auth_jwt.controller;

import com.eduardoguedes.auth_jwt.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

  @GetMapping
  private String getAll() {
    User user = new User("guedes", "bruno", "1234");

    return "New User register ok suceses";
  }
}
