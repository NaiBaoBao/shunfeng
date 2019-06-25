package two.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import two.example.demo.dao.AdminDao;
import two.example.demo.eneity.Admin;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public List<Admin> findAll(){
        return adminDao.findAll();
    }

    public Admin login(String id,String password) {
        List<Admin> adminList = adminDao.findById(id);
        if (adminList != null && adminList.size() > 0) {
            Admin admin = adminList.get(0);
            if (admin.getPassword().equals(password)){
                System.out.println("调用成功");
                System.out.println(id+" "+password);
                return admin;
            }
            else {
                System.out.println("error password");
                return null;
            }
        } else {
            System.out.println("error object");
            return null;
        }
    }
    public int insertAdmin(Admin admin){
        return adminDao.insertAdmin(admin);
    }
    public int updateAdmin(String id,String password){
        return adminDao.updateAdmin(id,password);
    }
    public int deleteAdmin(String id){
        return adminDao.deleteAdmin(id);
    }
}
