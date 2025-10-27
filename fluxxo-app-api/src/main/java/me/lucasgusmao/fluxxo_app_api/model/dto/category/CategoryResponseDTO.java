package me.lucasgusmao.fluxxo_app_api.model.dto.category;

import me.lucasgusmao.fluxxo_app_api.model.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public record CategoryResponseDTO(
        String name,
        String description,
        String type,
        String color,
        List<Transaction> transactions,
        boolean isDefault,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
