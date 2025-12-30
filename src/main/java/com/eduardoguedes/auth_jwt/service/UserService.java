package com.eduardoguedes.auth_jwt.service;

import com.eduardoguedes.auth_jwt.entity.DTO.RegisterUserRequest;
import com.eduardoguedes.auth_jwt.entity.DTO.UserResponse;
import com.eduardoguedes.auth_jwt.entity.User;
import com.eduardoguedes.auth_jwt.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
                     PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  public UserResponse register(RegisterUserRequest request) {

    if (userRepository.findByEmail(request.email()).isPresent()) {
      throw new IllegalArgumentException("Email already registered");
    }

    String passwordHash = passwordEncoder.encode(request.password());

    User user = new User(
            request.name(),
            request.email(),
            passwordHash
    );

    User savedUser = userRepository.save(user);

    return new UserResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail()
    );
  }

}
