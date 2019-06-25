package two.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.example.demo.eneity.Menu;
import two.example.demo.service.MenuService;

import java.util.List;

@RestController
@RequestMapping(value="menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "")
    public List<Menu> findAllMenu(){
        return menuService.findAll();
    }
    @GetMapping(value="/{type}")
    public List<Menu> findByType(@PathVariable("type") String type){
        return menuService.findByType(type);
    }
    @GetMapping(value="/keywords")
    public List<Menu> findByKeywords(@RequestParam("keywords")String keywords){
        return  menuService.findByKeywords(keywords);
    }
    @PostMapping(value="")
    public int insertMenu(Menu menu){
        return menuService.insertMenu(menu);
    }
    @DeleteMapping(value = "")
    public int deleteMenu(String name){
        return menuService.deleteMenu(name);
    }
    @PutMapping(value = "")
    public int updateMenu(Integer idMenu,String name,Integer num,Float price,String description,Byte[] image){
        return menuService.updateMenu(idMenu,name,num,price,description,image);
    }

}
