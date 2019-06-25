package two.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import two.example.demo.eneity.Order;

import java.util.List;

@Mapper
public interface OrderDao {
    public List<Order> findAll();
}
