package com.example.recipeBook.services;

import com.example.recipeBook.commands.RecipeCommand;
import com.example.recipeBook.domain.Recipe;

import java.util.Set;

/**
 * @author Jardel Brandao
 * @date 07/03/2025
 */
public interface RecipeService {
    Set<Recipe> getAllRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
