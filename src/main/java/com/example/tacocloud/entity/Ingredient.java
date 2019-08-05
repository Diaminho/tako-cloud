package com.example.tacocloud.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Ingredients")
public class Ingredient {
  @Id
  private String id;
  @Column (name = "name")
  private String name;
  @JoinColumn(name="type_id")
  @ManyToOne(targetEntity = Type.class, fetch = FetchType.LAZY)
  private Type type;

  @ManyToMany(mappedBy = "ingredients")
  private List<Taco> tacos = new ArrayList<>();

  public Ingredient() {
  }

  public Ingredient(String id, String name, Type type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public List<Taco> getTacos() {
    return tacos;
  }

  public void setTacos(List<Taco> tacos) {
    this.tacos = tacos;
  }
}
