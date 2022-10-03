package com.cydeo.controller;

import com.cydeo.model.PizzaOrder;
import com.cydeo.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final OrderRepository orderRepository;

    public HomeController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping("/")
    public String goHome(Model model){

        model.addAttribute("orders", orderRepository.readAll());
        List<PizzaOrder> list=new ArrayList<>(orderRepository.readAll());
        return"/home";
    }


}
