package com.example.tachoproject.repository;

import com.example.tachoproject.domains.Ingredient;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;

import java.util.List;
import java.util.Optional;

//public interface IngredientRepository extends Repository<Ingredient, String> {
//
//    Iterable<Ingredient> findAll();
//
//    Optional<Ingredient> findById(String id);
//
//    Ingredient save (Ingredient ingredient);
//
//
//} -> insted of we can create repository like this :

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
