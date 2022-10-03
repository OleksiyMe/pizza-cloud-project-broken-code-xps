package com.cydeo.repository;

import com.cydeo.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PizzaRepository {

    private static List<Pizza> pizzaList = new ArrayList<>();

    public Pizza createPizza(Pizza pizzaToSave) {
        pizzaList.add(pizzaToSave);
        return pizzaToSave;
    }

    public List<Pizza> readAll() {
        return pizzaList;
    }

    public Pizza getById(UUID uuid){

        for (Pizza each : pizzaList) {
            if (each.getId().equals(uuid)) return each;
        }
      return null;
    }


}
