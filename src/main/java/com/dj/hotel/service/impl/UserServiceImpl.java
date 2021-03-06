package com.dj.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.mapper.UserMapper;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 * @author 杨承雨
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
