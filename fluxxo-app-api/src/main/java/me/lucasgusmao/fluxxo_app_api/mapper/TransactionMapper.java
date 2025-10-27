package me.lucasgusmao.fluxxo_app_api.mapper;

import me.lucasgusmao.fluxxo_app_api.model.dto.transaction.TransactionRequestDTO;
import me.lucasgusmao.fluxxo_app_api.model.dto.transaction.TransactionResponseDTO;
import me.lucasgusmao.fluxxo_app_api.model.entity.Category;
import me.lucasgusmao.fluxxo_app_api.model.entity.Transaction;
import me.lucasgusmao.fluxxo_app_api.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "categoryId", target = "category")
    Transaction toEntity(TransactionRequestDTO dto);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "user.id", target = "userID")
    TransactionResponseDTO toDTO(Transaction transaction);

    default Category uuidToCategory(UUID id) {
        if (id == null) return null;
        Category c = new Category();
        c.setId(id);
        return c;
    }

    default UUID categoryToUuid(Category category) {
        return category == null ? null : category.getId();
    }

    default UUID userToUuid(User user) {
        return user == null ? null : user.getId();
    }
}
