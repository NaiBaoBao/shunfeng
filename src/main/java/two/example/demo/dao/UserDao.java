package two.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import two.example.demo.eneity.User;

import java.util.List;
@Mapper
public interface UserDao {
    public List<User> findAll();
    public List<User> findById(String id);
    public List<User> findByPhone(String phone);
    public int insertUser (User user);
    public int deleteUser(String id);
    public List<User> findClient();
    public List<User> findOwner();
    public int modifyPass(String id,String password);
    public int modifyUser(String id,String name,String address,String phone);
    public int updateUser(@Param("id") String id, @Param("password") String password,@Param("isorder") String isorder,@Param("name")String name, @Param("address") String address,@Param("phone")String phone);
}
