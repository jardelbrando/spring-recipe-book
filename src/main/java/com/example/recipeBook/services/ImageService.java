package com.example.recipeBook.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Jardel Brandão
 * @created : 14/08/2025
 **/
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
