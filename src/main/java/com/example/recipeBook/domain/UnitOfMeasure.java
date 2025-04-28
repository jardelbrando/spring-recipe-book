package com.example.recipeBook.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Jardel Brandao
 * @date 03/03/2025
 */
@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
