package com.cydeo.controller;

import com.cydeo.model.Pizza;
import com.cydeo.model.PizzaOrder;
import com.cydeo.repository.OrderRepository;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    public OrderController(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current/")
    public String orderForm(@RequestParam String pizzaId, Model model) {

        PizzaOrder pizzaOrder = new PizzaOrder();

        // Fix the getPizza method below in line 49.
        pizzaOrder.setPizza(getPizza(UUID.fromString(pizzaId)));

        model.addAttribute("pizzaOrder", pizzaOrder);

        return "/orderForm";
    }

    @PostMapping("")
    public String processOrder(@RequestParam String pizzaId, @ModelAttribute PizzaOrder pizzaOrder) {

        // Save the order
        pizzaOrder.setPizza(getPizza(UUID.fromString(pizzaId)));
        System.out.println(pizzaOrder);
        orderRepository.createPizzaOrder(pizzaOrder);

        return "redirect:/";
    }

    //TODO
    private Pizza getPizza(UUID pizzaId) {
        // Get the pizza from repository based on it's id
        return pizzaRepository.getById(pizzaId);
    }

}
