package me.lucasgusmao.fluxxo_app_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.lucasgusmao.fluxxo_app_api.mapper.CategoryMapper;
import me.lucasgusmao.fluxxo_app_api.model.dto.category.CategoryRequestDTO;
import me.lucasgusmao.fluxxo_app_api.model.dto.category.CategoryResponseDTO;
import me.lucasgusmao.fluxxo_app_api.model.entity.Category;
import me.lucasgusmao.fluxxo_app_api.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @PostMapping()
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody @Valid CategoryRequestDTO dto) {
         CategoryResponseDTO responseDTO = service.create(dto);
         return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        List<CategoryResponseDTO> categories = service.getAll(null);
        return ResponseEntity.ok(categories);
    }
}
