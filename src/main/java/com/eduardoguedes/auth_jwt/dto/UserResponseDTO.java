package com.eduardoguedes.auth_jwt.dto;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email
) {}
