package com.dj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.hotel.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * 菜品mapper
 * @author 成素鑫
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     *
     * @Title: findMenuByMid
     * @Description: 获取id
     * @Date: 2020年7月23日
     * @author: ck
     * @param: @return
     * @throws
     */
    Menu findMenuByMid(Integer mId) throws DataAccessException;

}
