package com.eduardoguedes.auth_jwt.dto;

public record UserRegisterRequestDTO(
        String name,
        String email,
        String password
) {
}
