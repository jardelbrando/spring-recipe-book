package com.example.recipeBook.bootstrap;

import com.example.recipeBook.domain.*;
import com.example.recipeBook.repositories.CategoryRespository;
import com.example.recipeBook.repositories.RecipeRepository;
import com.example.recipeBook.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Jardel Brandao
 * @date 06/03/2025
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRespository categoryRespository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRespository categoryRespository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRespository = categoryRespository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private void checkUOM(){

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> CupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!CupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if(!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if(!ounceUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> bunchUomOptional = unitOfMeasureRepository.findByDescription("Bunch");
        if(!bunchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
    }

    private  void checkCategory(){
        Optional<Category> americanCategory = categoryRespository.findByDescription("American");
        if(!americanCategory.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> italianCategory = categoryRespository.findByDescription("Italian");
        if(!italianCategory.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategory = categoryRespository.findByDescription("Mexican");
        if(!mexicanCategory.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> fastFoodCategory = categoryRespository.findByDescription("Fast Food");
        if(!fastFoodCategory.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> brazilianCategory = categoryRespository.findByDescription("Brazilian");
        if(!brazilianCategory.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>();

        checkUOM();
        checkCategory();

        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure pinch = unitOfMeasureRepository.findByDescription("Pinch").get();
        UnitOfMeasure ounce = unitOfMeasureRepository.findByDescription("Ounce").get();
        UnitOfMeasure bunch = unitOfMeasureRepository.findByDescription("Bunch").get();
        UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each").get();

        Category americanCategory = categoryRespository.findByDescription("American").get();

        Recipe spinachAndStrawberrySalad = new Recipe();
        spinachAndStrawberrySalad.setDescription("Spinach strawberry salad");
        spinachAndStrawberrySalad.setPrepTime(Integer.valueOf(10));
        spinachAndStrawberrySalad.setCookTime(Integer.valueOf(10));
        spinachAndStrawberrySalad.setServings(Integer.valueOf(8));
        spinachAndStrawberrySalad.setSource("allrecipes.com");
        spinachAndStrawberrySalad.setUrl("https://www.allrecipes.com/recipe/16409/spinach-and-strawberry-salad/");
        spinachAndStrawberrySalad.setDirections("Step 1"+
                "\n Toss spinach and strawberries together in a large bowl.\n"+
                "Step 2" +
                "\nWhisk oil, sugar, vinegar, sesame seeds, poppy seeds, and paprika together in a medium bowl; pour over spinach and strawberries, and toss to coat.\n");

        spinachAndStrawberrySalad.addIngredient(new Ingredient("Bunch of spinach", BigDecimal.valueOf(2), bunch, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Sliced strawberrys", BigDecimal.valueOf(4), cup, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Some vegetable oil of preference", BigDecimal.valueOf(0.5), cup, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Some whiteSugar", BigDecimal.valueOf(0.5), cup, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Some whiteWineVineger", BigDecimal.valueOf(0.5), cup, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Some sesameSeeds", BigDecimal.valueOf(2), tablespoon, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Some poppySeeds", BigDecimal.valueOf(1), tablespoon, spinachAndStrawberrySalad));
        spinachAndStrawberrySalad.addIngredient(new Ingredient("Some paprika", BigDecimal.valueOf(0.25), teaspoon, spinachAndStrawberrySalad));

        spinachAndStrawberrySalad.setDifficulty(Difficulty.EASY);

        Notes spinachAndStrawbeeryNotes = new Notes();
        spinachAndStrawbeeryNotes.setRecipeNotes("Just a regular and easy salad to your belly!");
        spinachAndStrawberrySalad.setNotes(spinachAndStrawbeeryNotes);
        spinachAndStrawbeeryNotes.setRecipe(spinachAndStrawberrySalad);

        spinachAndStrawberrySalad.getCategories().add(americanCategory);

        recipes.add(spinachAndStrawberrySalad);

        return recipes;
    }
}
