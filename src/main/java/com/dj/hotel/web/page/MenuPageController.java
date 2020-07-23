package com.dj.hotel.web.page;

import com.dj.hotel.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜品页面控制层
 * @author 成素鑫
 */
@Controller
@RequestMapping("/menu/")
public class MenuPageController {

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

}
