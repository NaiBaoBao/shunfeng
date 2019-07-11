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
    public List<Order> findById(String idCustomer){
        return orderDao.findById(idCustomer);
    }
    public List<Order> findByName(String nameCustomer){
        String n="%"+nameCustomer+"%";
        return orderDao.findByName(n);
    }
    public List<Order> findByPhone(String phoneCustomer){return orderDao.findByPhone(phoneCustomer);}
    public int insertOrder(Order order){
        return orderDao.insertOrder(order);
    }
}
