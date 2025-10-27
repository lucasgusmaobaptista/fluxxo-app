package me.lucasgusmao.fluxxo_app_api.repository;

import me.lucasgusmao.fluxxo_app_api.model.entity.Category;
import me.lucasgusmao.fluxxo_app_api.model.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findByUserId(UUID userId);

    Optional<Category> findByIdAndUserId(UUID id, UUID userId);

    Optional<Category> findByNameLikeIgnoreCaseAndUserId(String name, UUID userId);

    List<Category> findByTypeAndUserId(TransactionType type, UUID user_id);

    Boolean existsByNameAndUserId(String name, UUID userId);
}


