package com.cydeo.repository;

import com.cydeo.model.Pizza;
import com.cydeo.model.PizzaOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class OrderRepository {

    private static List<PizzaOrder> orderList = new ArrayList<>();

    public PizzaOrder createPizzaOrder(PizzaOrder orderToSave) {
        orderList.add(orderToSave);
        return orderToSave;
    }

    public List<PizzaOrder> readAll() {
        return orderList;
    }

    public PizzaOrder getById(UUID uuid){

        for (PizzaOrder each : orderList) {
            if (each.getId().equals(uuid)) return each;
        }
      return null;
    }


}
