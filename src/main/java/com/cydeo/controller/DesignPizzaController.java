package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Pizza;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller

public class DesignPizzaController {

    private final PizzaRepository pizzaRepository;

    public DesignPizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping ("/design")
    public String showDesignForm(Model model) {

        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);
        model.addAttribute("pizza", new Pizza());

        return "/design";

    }

    @PostMapping ("/design")
    public String showDesignForm2(@ModelAttribute("pizza") Pizza pizza) {

        pizzaRepository.createPizza(pizza);

       // model.addAttribute("uuid", pizza.getId());

        return "redirect:/orders/current/?pizzaId="+pizza.getId().toString();

    }



    @PostMapping("/createPizza")
    public String processPizza(Pizza pizza) {

        pizza.setId(UUID.randomUUID());
        pizzaRepository.createPizza(pizza);

        return "redirect:/orders/current?pizzaId=" + pizza.getId();

    }

}
