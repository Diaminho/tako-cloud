package com.example.tacocloud.entity;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders_Table")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message="Name is required")
  @Column
  private String name;
  @NotBlank(message="Street is required")
  @Column
  private String street;
  @NotBlank(message="City is required")
  @Column
  private String city;
  @NotBlank(message="State is required")
  @Column
  private String state;
  @NotBlank(message="Zip code is required")
  @Column
  private String zip;
  @CreditCardNumber(message="Not a valid credit card number")
  @Column
  private String ccNumber;
  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
          message="Must be formatted MM/YY")
  @Column
  private String ccExpiration;
  @Digits(integer=3, fraction=0, message="Invalid CVV")
  @Column(name = "cc_CVV")
  private short ccCVV;

  private Date placedAt;

  @ManyToMany(targetEntity=Taco.class)
  private List<Taco> tacos = new ArrayList<>();

  @PrePersist
  void placedAt() {
    this.placedAt = new Date();
  }

  public Order() {
  }

  public Order(String name, String street, String city, String state, String zip, String ccNumber, String ccExpiration, short ccCVV) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.ccNumber = ccNumber;
    this.ccExpiration = ccExpiration;
    this.ccCVV = ccCVV;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCcNumber() {
    return ccNumber;
  }

  public void setCcNumber(String ccNumber) {
    this.ccNumber = ccNumber;
  }

  public String getCcExpiration() {
    return ccExpiration;
  }

  public void setCcExpiration(String ccExpiration) {
    this.ccExpiration = ccExpiration;
  }

  public short getCcCVV() {
    return ccCVV;
  }

  public void setCcCVV(short ccCVV) {
    this.ccCVV = ccCVV;
  }

  public Date getPlacedAt() {
    return placedAt;
  }

  public void setPlacedAt(Date placedAt) {
    this.placedAt = placedAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Taco> getTacos() {
    return tacos;
  }

  public void setTacos(List<Taco> tacos) {
    this.tacos = tacos;
  }
}
