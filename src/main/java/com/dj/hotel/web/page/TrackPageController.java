package com.dj.hotel.web.page;

import com.dj.hotel.pojo.Menu;
import com.dj.hotel.service.MenuService;
import com.dj.hotel.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
