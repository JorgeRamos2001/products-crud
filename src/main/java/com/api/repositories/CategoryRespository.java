package com.api.repositories;

import com.api.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRespository extends JpaRepository<Category, UUID> {
    Optional<Category> findByCategoryName(String categoryName);
}
