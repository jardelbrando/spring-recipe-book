package com.example.recipeBook.services;

import com.example.recipeBook.commands.UnitOfMeasureCommand;
import com.example.recipeBook.domain.UnitOfMeasure;

import java.util.Set;

/**
 * @author : Jardel Brandão
 * @created : 28/07/2025
 **/

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUOM();
}
