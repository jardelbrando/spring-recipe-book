package com.example.recipeBook.services;

import com.example.recipeBook.domain.Recipe;
import com.example.recipeBook.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : Jardel Brandão
 * @created : 14/08/2025
 **/
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeService){
        this.recipeRepository = recipeService;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try{
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObject = new Byte[file.getBytes().length];

            int i = 0;

            for(byte b : file.getBytes()){
                byteObject[i++] = b;
            }

            recipe.setImage(byteObject);

            recipeRepository.save(recipe);
        }catch (IOException e){
            log.error("Error occurred when saving image", e);

            e.printStackTrace();
        }

    }
}
