package two.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping(value="order/id")
    public List<Order> findById(String idCustomer){
        return orderService.findById(idCustomer);
    }
    @GetMapping(value = "order/name")
    public List<Order> findByName(@RequestParam("nameCustomer")String nameCustomer){
        return orderService.findByName(nameCustomer);
    }
    @PostMapping(value = "order")
    public int insertOrder(Order order){
        return orderService.insertOrder(order);
    }
}
