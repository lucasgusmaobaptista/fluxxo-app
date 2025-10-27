package me.lucasgusmao.fluxxo_app_api.mapper;

import me.lucasgusmao.fluxxo_app_api.model.dto.category.CategoryRequestDTO;
import me.lucasgusmao.fluxxo_app_api.model.dto.category.CategoryResponseDTO;
import me.lucasgusmao.fluxxo_app_api.model.entity.Category;
import me.lucasgusmao.fluxxo_app_api.model.entity.User;
import me.lucasgusmao.fluxxo_app_api.model.enums.TransactionType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toEntity(CategoryRequestDTO dto);

    @Mapping(source = "type", target = "type")
    @Mapping(source = "user.id", target = "userId")
    CategoryResponseDTO toDTO(Category category);

    default String typeToString(TransactionType type) {
        return type == null ? null : type.name();
    }

    default UUID userToUuid(User user) {
        return user == null ? null : user.getId();
    }
}
