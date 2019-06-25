package two.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import two.example.demo.eneity.Order;
import two.example.demo.service.OrderService;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping(value = "order")
    public List<Order> findAll(){return orderService.findAll();}
}
