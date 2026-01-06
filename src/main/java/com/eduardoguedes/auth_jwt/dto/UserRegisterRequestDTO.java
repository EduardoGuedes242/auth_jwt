package com.eduardoguedes.auth_jwt.dto;

import com.eduardoguedes.auth_jwt.entity.Role;

public record UserRegisterRequestDTO(
        String name,
        String email,
        String password,
        Role role
) {
}
