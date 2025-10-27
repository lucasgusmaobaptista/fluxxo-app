package me.lucasgusmao.fluxxo_app_api.model.dto.category;

import me.lucasgusmao.fluxxo_app_api.model.entity.Transaction;
import me.lucasgusmao.fluxxo_app_api.model.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CategoryResponseDTO(
        UUID id,
        String name,
        String description,
        String type,
        String color,
        List<Transaction> transactions,
        User userId,
        boolean isDefault,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
