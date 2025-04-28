package com.example.recipeBook.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Jardel Brandao
 * @date 03/03/2025
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
