package com.dj.hotel.web.page;

import com.dj.hotel.pojo.Menu;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.MenuService;
import com.dj.hotel.service.ReconditeService;
import com.dj.hotel.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.math.BigDecimal;

/**
 * 记录页面控制层
 * @author ck
 */
@Controller
@RequestMapping("/track/")
public class TrackPageController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ReconditeService reconditeService;

    /**
     *
     * @Title: toAddMenu
     * @Description: 座位或包间的展示
     * @Date: 2020年7月23日
     * @author: ck
     * @param: @return
     * @throws
     */
    @RequestMapping("toAddMenu")
    public String toAddMenu(Integer mId, Model model) throws Exception {
        Menu menu = menuService.findMenuByMid(mId);
        model.addAttribute("menu", menu);
        return "track/insert";
    }

    /**
     *
     * @Title: toShow
     * @Description: 去查看自己的点餐记录展示
     * @Date: 2020年7月24日
     * @author: hhq
     * @param: @return
     * @throws
     */
    @RequestMapping("toShow")
    public String toShow() {
        return "track/show";
    }

    @RequestMapping("toHand")
    public String toHand(Model model){
    try {
        BigDecimal priceSum = trackService.priceSum();
        model.addAttribute("priceSum", priceSum);
        return "track/hand";
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "track/hand";
    }

}
