package com.example.tachoproject.controllers;

import com.example.tachoproject.domains.Ingredient;
import com.example.tachoproject.domains.Ingredient.Type.*;
import com.example.tachoproject.domains.Taco;
import com.example.tachoproject.domains.TacoOrder;
import com.example.tachoproject.repository.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.tachoproject.domains.Ingredient.Type;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),  filterByType(ingredients, type));
        }

    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }


    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }



    @PostMapping
    public String processTaco (@Valid Taco taco, Errors errors,
                               @ModelAttribute TacoOrder tacoOrder){
        System.out.println("My Taco "+taco);
        if (errors.hasErrors()){
            return "design";
        }
        tacoOrder.addTaco(taco);
        System.out.println(taco);
        log.info("Processing Tacho :  {} ;", taco);

        return "redirect:/orders/current";
    }





}
