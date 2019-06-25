package two.example.demo.service;

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
    public User login(String id,String password){
        List<User> userList=userDao.findById(id);
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
    public int updateUser(String id,String password,String isorder,String name,String address){
        return userDao.updateUser(id,password,isorder,name,address);
    }
}
