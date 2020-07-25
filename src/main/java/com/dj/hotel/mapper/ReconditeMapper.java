package com.dj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.hotel.pojo.Recondite;
import org.springframework.dao.DataAccessException;

/**
 * 点餐记录mapper接口
 * @author 杨承雨
 */
public interface ReconditeMapper extends BaseMapper<Recondite> {

    /**
     * insertRecondite
     * 轨迹
     * ck
     * @param recondite
     * @throws DataAccessException
     */
    void insertRecondite(Recondite recondite) throws DataAccessException;

}
