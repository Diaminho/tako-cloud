package com.example.tacocloud.controller;

import com.example.tacocloud.entity.Order;
import com.example.tacocloud.repository.OrderRepository;
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

@Controller
@RequestMapping("/orders")
public class OrderController {
  private static final Logger logger = LogManager.getLogger(OrderController.class);

  @Autowired
  OrderRepository orderRepository;

  @GetMapping("/current")
  public String orderForm(Model model) {
    logger.info("order Form");
    model.addAttribute("order", new Order());
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@Valid Order order, Errors errors) {
    if (errors.hasErrors()) {
      logger.info("Order error: " + errors.getObjectName());
      return "orderForm";
    }
    logger.info("Order submitted: " + order);
    orderRepository.save(order);
    return "redirect:/";
  }
}
