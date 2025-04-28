package com.example.recipeBook.controllers;
import com.example.recipeBook.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jardel Brandao
 * @date 21/02/2025
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("Getting index page...");
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}
