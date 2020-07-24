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
     * @Title: show
     * @Description: 菜品展示
     * @Date: 2020年7月23日
     * @author: csx
     * @param: @param menu, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("show")
    public ResultModel<Object> show(Menu menu, Integer pageNo, @SessionAttribute("user") User user){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
            if (user.getUserLevel() == SysConstant.USER_LEVEL_TWO) {
               queryWrapper.eq("menu_status", SysConstant.MENU_STATUS_ZERO);
            }
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            IPage<Menu> page = new Page<>(pageNo, SysConstant.MENU_PAGE_SIZE);
            IPage<Menu> pageInfo = menuService.page(page, queryWrapper);
            map.put("menuList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
                e.printStackTrace();
                return new ResultModel<>().error("服务器异常");
        }
    }

    /**
     *
     * @Title: addMenu
     * @Description: 上架菜品
     * @Date: 2020年7月23日
     * @author: hhq
     * @param: @return
     * @throws
     */
    @RequestMapping("addMenu")
    public ResultModel<Object> addMenu(Menu menu){
        try {
            QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("menu_name", menu.getMenuName());
            Menu menu1 = menuService.getOne(queryWrapper);
            if(menu1 != null){
                return new ResultModel<>().error("已有该菜品");
            } else {
                menuService.save(menu);
                return new ResultModel<>().success("菜品增加成功");
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

}
