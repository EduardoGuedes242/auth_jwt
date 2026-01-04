package com.eduardoguedes.auth_jwt.service;

import com.eduardoguedes.auth_jwt.config.JwtService;
import com.eduardoguedes.auth_jwt.dto.LoginRequestDTO;
import com.eduardoguedes.auth_jwt.dto.LoginResponseDTO;
import com.eduardoguedes.auth_jwt.dto.UserRegisterRequestDTO;
import com.eduardoguedes.auth_jwt.dto.UserResponseDTO;
import com.eduardoguedes.auth_jwt.entity.User;
import com.eduardoguedes.auth_jwt.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;


  public AuthService(UserRepository userRepository,
                     PasswordEncoder passwordEncoder,
                     JwtService jwtService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
  }

  public LoginResponseDTO authenticate(LoginRequestDTO loginRequestDTO) {
    User user = userRepository.findByEmail(loginRequestDTO.email())
            .orElseThrow(() -> new RuntimeException("Invalid credentials"));

    if(!passwordEncoder.matches(loginRequestDTO.password(), user.getPasswordHash())) {
      throw new RuntimeException("Invalid credentials");
    }

    String token = jwtService.generateToken(user);

    LoginResponseDTO responseDTO = new LoginResponseDTO(token, "Bearer");

    return responseDTO;
  }

  @Transactional
  public UserResponseDTO register(UserRegisterRequestDTO userRequestDTO) {

    if (userRepository.existsByEmail(userRequestDTO.email())) {
      throw new IllegalArgumentException("Email already registered");
    }

    String passwordHash = passwordEncoder.encode(userRequestDTO.password());

    User user = new User(
            userRequestDTO.name(),
            userRequestDTO.email(),
            passwordHash
    );

    User savedUser = userRepository.save(user);

    return new UserResponseDTO(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail()
    );
  }
}
