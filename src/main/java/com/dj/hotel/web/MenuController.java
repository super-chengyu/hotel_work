package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.Home;
import com.dj.hotel.pojo.Menu;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜品页面控制层
 * @author 成素鑫
 */
@RestController
@RequestMapping("/menu/")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     *
     * @Title: showMenu
     * @Description: 菜品展示
     * @Date: 2020年7月23日
     * @author: csx
     * @param: @param menu, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("show")
    public ResultModel<Object> showHome(Menu menu, Integer pageNo, @SessionAttribute("user") User user){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
            if (user.getUserLevel() == SysConstant.user_level_two) {
               queryWrapper.eq("menu_status", SysConstant.menu_status_zero);
            }
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            IPage<Menu> page = new Page<>(pageNo, SysConstant.HOME_PAGE_SIZE);
            IPage<Menu> pageInfo = menuService.page(page, queryWrapper);
            map.put("menuList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

}
