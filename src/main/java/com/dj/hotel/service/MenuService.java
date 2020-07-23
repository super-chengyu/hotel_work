package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Menu;

/**
 * 菜品service
 * @author 成素鑫
 */
public interface MenuService extends IService<Menu> {

    Menu findMenuByMid(Integer mId) throws Exception;
}
