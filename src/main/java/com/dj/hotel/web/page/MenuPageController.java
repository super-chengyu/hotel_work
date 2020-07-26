package com.dj.hotel.web.page;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.hotel.pojo.Menu;
import com.dj.hotel.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜品页面控制层
 * @author 成素鑫
 */
@Controller
@RequestMapping("/menu/")
public class MenuPageController {

    @Autowired
    private MenuService menuService;

    /**
     * 去菜品展示
     * @Date: 2020年7月23日
     * @author: csx
     * @return
     */
    @RequestMapping("toShow")
    public String toShow(){
        return "menu/show";
    }


    /**
     * 去展示本条菜品介绍
     * @Date: 2020年7月24日
     * @author: hhq
     * @return
     */
    @RequestMapping("toMenuList")
    public String toAddMenus(Integer id, Model model){
        Menu menu = menuService.getById(id);
        model.addAttribute("menu",menu);
        return "menu/one_menu";
    }

    /**
     * 菜品去上架
     * @Date: 2020年7月24日
     * @author: hhq
     * @return
     */
    @RequestMapping("toAddMenu")
    public String toAddMenus(){
        return "menu/add";
    }

    /**
     * 菜品去修改
     * @Date: 2020年7月24日
     * @author: hhq
     * @return
     */
    @RequestMapping("toUpdateMenu/{id}")
    public String toUpdateMenu(@PathVariable("id") Integer id, Model model){
        Menu menu1 = menuService.getById(id);
        model.addAttribute("menu",menu1);
        return "menu/update";
    }

}
