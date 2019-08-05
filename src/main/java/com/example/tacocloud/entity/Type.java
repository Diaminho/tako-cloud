package com.example.tacocloud.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Types")
public class Type {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column
  String name;

  @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Ingredient> ingredients = new ArrayList<>();

  public Type() {
  }

  public Type(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Ingredient> getIngredientsT() {
    return ingredients;
  }

  public void setIngredientsT(List<Ingredient> ingredientsT) {
    this.ingredients = ingredientsT;
  }

  /*public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }*/
}
