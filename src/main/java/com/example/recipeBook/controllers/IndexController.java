package com.example.recipeBook.controllers;

import com.example.recipeBook.domain.Category;
import com.example.recipeBook.domain.UnitOfMeasure;
import com.example.recipeBook.repositories.CategoryRespository;
import com.example.recipeBook.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Jardel Brandao
 * @date 21/02/2025
 */

@Controller
public class IndexController {

    private CategoryRespository categoryRespository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRespository categoryRespository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRespository = categoryRespository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> category = categoryRespository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is: "+ category.get().getId());
        System.out.println("Unit of Measure Id is: "+ unitOfMeasure.get().getId());

        return "index";
    }
}
