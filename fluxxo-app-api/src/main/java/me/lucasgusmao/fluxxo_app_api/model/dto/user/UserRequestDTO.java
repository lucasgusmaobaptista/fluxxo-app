package me.lucasgusmao.fluxxo_app_api.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "Campo obrigatório!")
        @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres.")
        String name,
        @NotBlank(message = "Campo obrigatório!")
        @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
        @Email(message = "Email inválido.")
        String email,
        @NotBlank(message = "Campo obrigatório!")
        @Size(min = 3, max = 30, message = "A senha deve ter entre 3 e 30 caracteres.")
        String password,
        String imageUrl
) {
}
