package com.example.tacocloud.controller;

import com.example.tacocloud.entity.Ingredient;
import com.example.tacocloud.entity.Taco;
import com.example.tacocloud.entity.Type;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.TacoRepository;
import com.example.tacocloud.repository.TypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DesignTacoController {
  private static final Logger logger = LogManager.getLogger(DesignTacoController.class);

  @Autowired
  IngredientRepository ingredientRepository;

  @Autowired
  TacoRepository tacoRepository;

  @Autowired
  TypeRepository typeRepository;

  /*List<Ingredient> ingredients = Arrays.asList(
          new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
          new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
          new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
          new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
          new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
          new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
          new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
          new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
          new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
          new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
  );*/


  @GetMapping
  public String showDesignForm(Model model) {
    List<Type> types = typeRepository.findAll();
    List<Ingredient> ingredients = ingredientRepository.findAll();
    types.forEach(type -> {
      model.addAttribute(type.getName().toLowerCase(),
              filterByType(ingredients, type));
    });
    model.addAttribute("design", new Taco());
    //logger.info("Taco designed");
    return "design";
  }

  private List<Ingredient> filterByType(
          List<Ingredient> ingredients, Type type) {
    return ingredients
            .stream()
            .filter(x -> x.getType().equals(type))
            .collect(Collectors.toList());
  }

  @PostMapping
  public String processDesign(@Valid Taco design, Errors errors) {
    /*if (errors.hasErrors()) {
      logger.info("Processing errors: " + errors.getObjectName());
      return "design";
    }*/
    logger.info("Processing design: " + design);
    tacoRepository.save(design);
    return "redirect:/orders/current";
  }
}
