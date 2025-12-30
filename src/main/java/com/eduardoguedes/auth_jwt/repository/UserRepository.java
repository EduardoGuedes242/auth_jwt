package com.eduardoguedes.auth_jwt.repository;

import com.eduardoguedes.auth_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmail(String email);

}
