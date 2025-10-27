package me.lucasgusmao.fluxxo_app_api.model.dto.user;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
        String name,
        String email,
        String username,
        String imageUrl,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
