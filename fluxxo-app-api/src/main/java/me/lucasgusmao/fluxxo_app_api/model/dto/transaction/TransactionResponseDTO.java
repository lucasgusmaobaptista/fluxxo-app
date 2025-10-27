package me.lucasgusmao.fluxxo_app_api.model.dto.transaction;

import me.lucasgusmao.fluxxo_app_api.model.enums.PaymentMethod;
import me.lucasgusmao.fluxxo_app_api.model.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponseDTO(
        UUID id,
        String description,
        String notes,
        TransactionStatus status,
        PaymentMethod paymentMethod,
        BigDecimal amount,
        UUID categoryId,
        UUID userID,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
