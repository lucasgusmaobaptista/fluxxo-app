package me.lucasgusmao.fluxxo_app_api.mapper;

import me.lucasgusmao.fluxxo_app_api.model.dto.user.UserRequestDTO;
import me.lucasgusmao.fluxxo_app_api.model.dto.user.UserResponseDTO;
import me.lucasgusmao.fluxxo_app_api.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO dto);

    UserResponseDTO toDTO(User user);
}
