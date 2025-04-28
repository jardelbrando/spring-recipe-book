package com.example.recipeBook.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * @author Jardel Brandao
 * @date 03/03/2025
 */

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
