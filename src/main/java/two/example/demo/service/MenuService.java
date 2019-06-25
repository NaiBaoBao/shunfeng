package two.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import two.example.demo.dao.MenuDao;
import two.example.demo.eneity.Menu;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public List<Menu> findAll(){
        return menuDao.findAll();
    }
    public List<Menu> findByType(String type){
        return menuDao.findByType(type);
    }
    public List<Menu> findByKeywords(String keywords){
        String k="%"+keywords+"%";
        return menuDao.findByKeywords(k);
    }
    public int insertMenu(Menu menu){
        return menuDao.insertMenu(menu);
    }
    public int deleteMenu(String name){
        return menuDao.deleteMenu(name);
    }
    public int updateMenu(Integer idMenu,String name,Integer num,Float price,String description,Byte[] image){
        return menuDao.updateMenu(idMenu,name,num,price,description,image);
    }

}
