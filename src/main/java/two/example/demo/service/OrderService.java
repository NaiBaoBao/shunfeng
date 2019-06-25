package two.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import two.example.demo.eneity.Order;
import org.springframework.stereotype.Service;
import two.example.demo.dao.OrderDao;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    public List<Order> findAll(){
        return orderDao.findAll();
    }
}
