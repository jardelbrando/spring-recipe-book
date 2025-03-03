package com.example.recipeBook.repositories;

import com.example.recipeBook.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jardel Brandao
 * @date 03/03/2025
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
