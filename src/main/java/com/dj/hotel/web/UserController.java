package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户控制层
 * 2020-07-23
 * @author 杨承雨
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @Title: loginByNameAndPwd
     * @Description: 用户登录
     * @Date: 2020年7月23日
     * @author: ycy
     * @param: @param user
     * @param: @return
     * @return:
     * @throws
     */
    @RequestMapping("loginByNameAndPwd")
    public ResultModel<Object> loginByNameAndPwd(User user, HttpSession httpSession){
        try {
            if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getUserPwd())){
                return new ResultModel<>().error("用户信息不能为空");
            }
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name", user.getUserName());
            queryWrapper.eq("user_pwd", user.getUserPwd());
            User user1 = userService.getOne(queryWrapper);
            if (user1 == null){
                return new ResultModel<>().error("请核实您的信息");
            }
            httpSession.setAttribute("user", user1);
            return new ResultModel<>().success("登录成功");
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }
}
