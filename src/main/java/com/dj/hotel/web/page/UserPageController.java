package com.dj.hotel.web.page;

import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户页面控制层
 * @author 杨承雨
 */
@Controller
@RequestMapping("/user/")
public class UserPageController {

    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "user/login";
    }

    /**
     * 用户去注册
     * @return
     */
    @RequestMapping("toRegisterUser")
    public String toRegisterUser(){
        return "user/register";
    }

    /**
     * 用户去展示
     * @Date: 2020年7月24日
     * @author: csx
     * @return
     */
    @RequestMapping("toShow")
    public String toShow(){
        return "user/show";
    }
}
