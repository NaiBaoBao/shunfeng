package two.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import two.example.demo.eneity.Admin;

import java.util.List;

@Mapper
public interface AdminDao {
    public List<Admin> findAll();
    public List<Admin> findById(String id);
    public int insertAdmin(Admin admin);
    public int updateAdmin(@Param("id")String id,@Param("password")String password);
    public int deleteAdmin(String id);
}
