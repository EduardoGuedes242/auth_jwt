package com.eduardoguedes.auth_jwt.entity.DTO;

public record RegisterUserRequest(
        String name,
        String email,
        String password
) {
}
