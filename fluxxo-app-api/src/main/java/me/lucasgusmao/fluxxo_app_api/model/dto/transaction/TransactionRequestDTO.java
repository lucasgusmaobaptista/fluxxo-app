package me.lucasgusmao.fluxxo_app_api.model.dto.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.lucasgusmao.fluxxo_app_api.model.entity.Category;
import me.lucasgusmao.fluxxo_app_api.model.enums.PaymentMethod;
import me.lucasgusmao.fluxxo_app_api.model.enums.TransactionStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequestDTO(
        @Size(max = 255)
        String description,
        @Size(max = 255)
        String notes,
        TransactionStatus status,
        PaymentMethod paymentMethod,
        @NotNull(message = "Esse campo é obrigatório")
        BigDecimal amount,
        UUID categoryId
) {
}
