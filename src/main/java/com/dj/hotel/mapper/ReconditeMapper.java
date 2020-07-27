package com.dj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

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

    /**
     * findReconditeById
     * 已完成订单的查询
     * ck
     * @throws DataAccessException
     */
    List<Recondite> findReconditeById(@Param("recondite") Recondite recondite, @Param("user") User user) throws DataAccessException;

    Integer getHomeById(Integer id) throws DataAccessException;
}
