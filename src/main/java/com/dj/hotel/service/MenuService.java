package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Menu;

/**
 * 菜品service
 * @author 成素鑫
 */
public interface MenuService extends IService<Menu> {

    /**
     *
     * @Title: findMenuByMid
     * @Description: 获取id
     * @Date: 2020年7月24日
     * @author: ck
     * @param: @return
     * @throws
     */
    Menu findMenuByMid(Integer mId) throws Exception;
}
