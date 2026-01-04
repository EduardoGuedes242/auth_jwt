package com.eduardoguedes.auth_jwt.controller;

import com.eduardoguedes.auth_jwt.dto.LoginRequestDTO;
import com.eduardoguedes.auth_jwt.dto.LoginResponseDTO;
import com.eduardoguedes.auth_jwt.dto.UserRegisterRequestDTO;
import com.eduardoguedes.auth_jwt.dto.UserResponseDTO;
import com.eduardoguedes.auth_jwt.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/register")
  public UserResponseDTO registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
    return authService.register(userRegisterRequestDTO);
  }

  @PostMapping("/login")
  public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
    return authService.authenticate(loginRequestDTO);
  }

}
