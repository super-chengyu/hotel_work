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
     * 去厨师管理页面
     * @return
     */
    @RequestMapping("toShowUserLevel5")
    public String toShowUserLevel5(){
        return "user/show_user_level5";
    }
}
