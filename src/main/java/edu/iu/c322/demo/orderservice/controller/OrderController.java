package edu.iu.c322.demo.orderservice.controller;

import edu.iu.c322.demo.orderservice.model.Order;
import edu.iu.c322.demo.orderservice.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Order order){
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

}
