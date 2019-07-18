package two.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import two.example.demo.dao.UserDao;
import two.example.demo.eneity.Order;
import org.springframework.stereotype.Service;
import two.example.demo.dao.OrderDao;
import two.example.demo.eneity.User;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
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
    public List<Order> findByIdOrder(Integer idOrder){
        return orderDao.findByIdOrder(idOrder);
    }
    public int addIdOrder(){
        List<Order> orderList= orderDao.findAll();
        if(orderList.get(orderList.size()-1).getIdOrder()==null){
            return 1;
        }
        else
            return orderList.get(orderList.size()-1).getIdOrder()+1;
    }

    public boolean addOrder(String id,Integer idMenu,String name,String type,Integer status,Integer quantity,Long time){
        Integer idOrder;
        List<Order> orderList= orderDao.findAll();
        if(orderList.get(orderList.size()-1).getIdOrder()==null){
            idOrder=1;
        }
        else
            idOrder=orderList.get(orderList.size()-1).getIdOrder()+1;
        Order order=new Order();
        order.setIdOrder(idOrder);
        order.setIdMenu(idMenu);
        order.setTime(time);
        System.out.println(time);
        order.setIdCustomer(id);
        order.setName(name);
        order.setQuantity(quantity);
        order.setStatus(0);
        User user= userDao.findById(id).get(0);
        String clientName=user.getName();
        String address=user.getAddress();
        String phone=user.getPhone();
        order.setNameCustomer(clientName);
        order.setPhoneCustomer(phone);
        order.setAddressCustomer(address);
        orderDao.insertOrder(order);
        return true;
    }

    public boolean confirm(Integer idOrder){
       List<Order> orderList=orderDao.findByIdOrder(idOrder);
       Order order=new Order();
       for(int i=0;i<orderList.size();i++){
           order.setStatus(1);
       }
        return true;
    }
}
