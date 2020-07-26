package com.dj.hotel.web.page;

import com.dj.hotel.service.ReconditeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 点餐记录pageController
 * @author 杨承雨
 */

@Controller
@RequestMapping("/recondite/")
public class ReconditePageController {

    @Autowired
    private ReconditeService reconditeService;

    /**
     * toReconditeShowEatStatus
     * 去查看已点餐订单查询
     * @Date: 2020年7月26日
     * @author: ck
     * @return
     */
    @RequestMapping("toReconditeShowEatStatus")
    public String toReconditeShowEatStatus(){
        return "recondite/recondite_show_eat_status";
    }


}
