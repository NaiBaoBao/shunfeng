package two.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.example.demo.eneity.Admin;
import two.example.demo.eneity.User;
import two.example.demo.service.AdminService;
import two.example.demo.service.UserService;

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
    @DeleteMapping(value = "user")
    public int deleteUser(String id){
        return userService.deleteUser(id);
    }
    @PutMapping(value="user")
    public int updateUser(String id,String password,String isorder,String name,String address){
        return userService.updateUser(id,password,isorder,name,address);
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

}
