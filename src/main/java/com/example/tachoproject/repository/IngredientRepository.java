package com.example.tachoproject.repository;

import com.example.tachoproject.domains.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save (Ingredient ingredient);


}
