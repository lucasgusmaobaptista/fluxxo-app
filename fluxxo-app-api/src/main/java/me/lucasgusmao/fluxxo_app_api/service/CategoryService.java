package me.lucasgusmao.fluxxo_app_api.service;

import lombok.RequiredArgsConstructor;
import me.lucasgusmao.fluxxo_app_api.exception.custom.AlreadyExistsException;
import me.lucasgusmao.fluxxo_app_api.mapper.CategoryMapper;
import me.lucasgusmao.fluxxo_app_api.model.dto.category.CategoryRequestDTO;
import me.lucasgusmao.fluxxo_app_api.model.dto.category.CategoryResponseDTO;
import me.lucasgusmao.fluxxo_app_api.model.entity.Category;
import me.lucasgusmao.fluxxo_app_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        //TODO get current user and set to category
        Category category = mapper.toEntity(dto);
        if (repository.existsByNameAndUserId(category.getName(), null)) {
            throw new AlreadyExistsException("A categoria " + category.getName() + " já existe.");
        }
        category = repository.save(category);
        return mapper.toDTO(category);
    }
}

