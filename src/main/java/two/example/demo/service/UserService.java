package two.example.demo.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import two.example.demo.dao.AdminDao;
import two.example.demo.dao.UserDao;
import two.example.demo.eneity.User;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }
    public User findById(String id){
        List<User> userList= userDao.findById(id);
        User user=userList.get(0);
        return user;
    }
    public User findByPhone(String phone){
        List<User> userList= userDao.findByPhone(phone);
        User user=userList.get(0);
        return user;
    }
    public User login(String id,String password){
        List<User> userList=userDao.findByPhone(id);
        if(userList!=null&&userList.size()>0){
            User user=userList.get(0);
            if(user.getPassword().equals(password)){
                System.out.println("调用成功");
                System.out.println(id+" "+password);
                return user;
            }
            else{
                System.out.println("error password");
                return null;
            }
        }
        else{
            System.out.println("error object");
            return null;
        }
    }
    public int insertUser(User user){
        return userDao.insertUser(user);
    }
    public int deleteUser(String id){
        return userDao.deleteUser(id);
    }
    public int updateUser(@Param("id") String id,@Param("password") String password, @Param("isorder") String isorder,@Param("name") String name,@Param("address") String address,@Param("phone")String phone){
        return userDao.updateUser(id,password,isorder,name,address,phone);
    }
    public List<User> findClient(){
        return userDao.findClient();
    }
    public int modifyUser(String id,String name,String address,String phone){
        return userDao.modifyUser(id, name, address, phone);
    }

    public List<User> findOwner(){
        return userDao.findOwner();
    }

    public int modifyPass(String id,String oldPass,String newPass){
        List<User> users=userDao.findById(id);
        User user=users.get(0);
        if (user.getPassword().equals(oldPass)){
            return userDao.modifyPass(id,newPass);
        }
        return 0;
    }
}
