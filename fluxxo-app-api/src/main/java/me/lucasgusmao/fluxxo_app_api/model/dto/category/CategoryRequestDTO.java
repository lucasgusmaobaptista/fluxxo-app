package me.lucasgusmao.fluxxo_app_api.model.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.lucasgusmao.fluxxo_app_api.model.enums.TransactionType;

public record CategoryRequestDTO(
        @NotBlank(message = "Campo obrigatório!")
        @Size(max = 255, message = "O nome deve ter no máximo 100 caracteres.")
        String name,
        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
        String description,
        @NotNull(message = "Campo obrigatório!")
        TransactionType type,
        String color
) {
}
