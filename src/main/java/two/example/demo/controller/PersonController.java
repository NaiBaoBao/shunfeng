package two.example.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.example.demo.eneity.Admin;
import two.example.demo.eneity.User;
import two.example.demo.service.AdminService;
import two.example.demo.service.UserService;
import two.example.demo.vo.UserVo;

import java.util.List;

@RestController
@RequestMapping(value = "person")
public class PersonController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "admin")
    public List<Admin> findAllAdmin(){
        return adminService.findAll();
    }

    @GetMapping(value="user")
    public List<User> findAllUser(){return userService.findAll();}
    @GetMapping(value = "user/id")
    public User findById(String id){return userService.findById(id);}

    @GetMapping(value = "login")
    public UserVo login(String id,String password){
        Admin admin=adminService.login(id, password);
        User user=userService.login(id, password);
        if (admin==null){
            if (user==null){
                return null;
            }
            else{
                UserVo userVo=new UserVo();
                userVo.setId(user.getId());
                userVo.setIdentity(user.getIsorder());
                return userVo;
            }
        }
        else {
            UserVo userVo=new UserVo();
            userVo.setId(admin.getId());
            userVo.setIdentity(2);
            return userVo;
        }
    }
    @PostMapping(value="/admin/login")
    public Admin adminlogin(String id,String password){
        return adminService.login(id,password);
    }
    @PostMapping(value="/user/login")
    public User userlogin(String id,String password){
        return userService.login(id,password);
    }
    @PostMapping(value = "user")
    public int insertUser(User user){
        return userService.insertUser(user);
    }
    @GetMapping(value = "user/add")
    public int insertClient(User user){
        user.setPassword("123456");
        user.setIsorder(0);
        return userService.insertUser(user);
    }
    @GetMapping(value = "/owner/add")
    public int insertOwner(User user){
        user.setPassword("123456");
        user.setIsorder(1);
        return userService.insertUser(user);
    }
    @DeleteMapping(value = "user")
    public int deleteUser(String id){
        return userService.deleteUser(id);
    }
    @GetMapping(value="user/modified")
    public int updateUser(@Param("id") String id,@Param("password") String password,@Param("isorder")String isorder,@Param("name") String name,@Param("address") String address,@Param("phone") String phone){
        return userService.updateUser(id,password,isorder,name,address,phone);
    }
    @PostMapping(value="admin")
    public int insertAdmin(Admin admin){
        return adminService.insertAdmin(admin);
    }
    @PutMapping(value="admin")
    public int updateAdmin(String id,String password){
        return adminService.updateAdmin(id,password);
    }
    @DeleteMapping(value = "admin")
    public int deleteAdmin(String id){
        return adminService.deleteAdmin(id);
    }

    @GetMapping(value = "client")
    public List<User> findClient(){
        return userService.findClient();
    }
    @GetMapping(value = "owner")
    public List<User> findOwner(){
        return userService.findOwner();
    }

    @GetMapping(value = "user/modify")
    public int modifyUser(String id,String name,String address,String phone){
        return userService.modifyUser(id, name, address, phone);
    }

    @GetMapping(value = "user/modifyPass")
    public int modifyPass(String id,String oldPass,String newPass){
        return userService.modifyPass(id, oldPass, newPass);
    }
}
