package com.dj.hotel.web;

import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 * @author 杨承雨
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;
}
