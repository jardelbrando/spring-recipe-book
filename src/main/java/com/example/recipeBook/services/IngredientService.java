package com.example.recipeBook.services;

import com.example.recipeBook.commands.IngredientCommand;

/**
 * @author : Jardel Brandão
 * @created : 15/07/2025
**/

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
