package two.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.example.demo.eneity.Menu;
import two.example.demo.service.MenuService;
import two.example.demo.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value="menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "")
    public List<Menu> findAllMenu() {
        return menuService.findAll();
    }

    @GetMapping(value = "/{type}")
    public List<Menu> findByType(@PathVariable("type") String type) {
        return menuService.findByType(type);
    }

    @GetMapping(value = "/keywords")
    public List<Menu> findByKeywords(@RequestParam("keywords") String keywords) {
        return menuService.findByKeywords(keywords);
    }

    @GetMapping(value = "insert")
    public int insertMenu(Menu menu) {
        System.out.println(menu.toString());
        return menuService.insertMenu(menu);
    }

    @DeleteMapping(value = "")
    public int deleteMenu(String name) {
        return menuService.deleteMenu(name);
    }

    @PutMapping(value = "")
    public int updateMenu(Integer idMenu, String name, Integer num, Float price, String description) {
        return menuService.updateMenu(idMenu, name, num, price, description);
    }

    @GetMapping(value = "modify")
    public int modifyMenu(Integer idMenu, String name, String type, Integer num, Float price, String description) {
        return menuService.modifyMenu(idMenu, name, type, num, price, description);
    }

    @PostMapping(value = "order")
    public boolean addOrder(String id,Integer idMenu,String name,String type,Integer status,Integer quantity,Long time) {
        if (orderService.addOrder(id, idMenu, name, type, status, quantity,time) == true && menuService.orderMenu(idMenu, quantity) == true){
            return true;
        }
        else {
            return false;
        }
    }

}
