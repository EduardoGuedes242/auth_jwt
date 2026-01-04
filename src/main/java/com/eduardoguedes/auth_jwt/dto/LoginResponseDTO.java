package com.eduardoguedes.auth_jwt.dto;

public record LoginResponseDTO(
        String accessToken,
        String tokenType
) {
}
