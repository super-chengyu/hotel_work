package com.dj.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.mapper.MenuMapper;
import com.dj.hotel.pojo.Menu;
import com.dj.hotel.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜品service实现类
 * @author 成素鑫
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu findMenuByMid(Integer mId) throws Exception {
        // TODO Auto-generated method stub
        return menuMapper.findMenuByMid(mId);
    }

}
