package com.example.recipeBook.repositories;

import com.example.recipeBook.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Jardel Brandao
 * @date 03/03/2025
 */
public interface CategoryRespository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
