package com.eduardoguedes.auth_jwt.entity.DTO;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email
) {}
