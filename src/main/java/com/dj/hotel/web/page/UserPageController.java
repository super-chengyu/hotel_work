package com.dj.hotel.web.page;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
     * 厨师去注册
     * @return
     */
    @RequestMapping("toInsertUserLevel5")
    public String toInsertUserLevel5(){
        return "user/insert_user_level5";
    }

    /**
     * 去厨师管理页面
     * @return
     */
    @RequestMapping("toShowUserLevel5")
    public String toShowUserLevel5(){
        return "user/show_user_level5";
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

    /**
     * 去手机号验证页面
     * @Date: 2020年7月24日
     * @author: ck
     * @return
     */
    @RequestMapping("toUpdateUserLevel3")
    public String toUpdateUserLevel3(Model model, @SessionAttribute User user) throws Exception{
        model.addAttribute("user", user);
        return "user/update_user_level3";
    }

    /**
     * 去找回密码
     * @Date: 2020年7月25日
     * @author: csx
     * @return
     */
    @RequestMapping("toRecovery")
    public String toRecovery(){
        return "user/recovery";
    }

    /**
     * 去设置新密码
     * @Date: 2020年7月26日
     * @author: csx
     * @return
     */
    @RequestMapping("toNewPwd")
    public String toNewPwd(String userEmail, Model model){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_email", userEmail);
        User user2 = userService.getOne(queryWrapper);
        model.addAttribute("us", user2);
        return "user/new_pwd";
    }
}
