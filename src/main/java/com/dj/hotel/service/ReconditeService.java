package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.User;
import org.springframework.dao.DataAccessException;

import java.util.List;


/**
 * 点餐记录service接口
 * @author 杨承雨
 */
public interface ReconditeService extends IService<Recondite> {

    /**
     * insertRecondite
     * 新增信息表的信息
     * ck
     * @throws DataAccessException
     */
    void insertRecondite(Recondite recondite) throws Exception;

    /**
     * findReconditeById
     * 已完成订单的查询
     * ck
     * @throws DataAccessException
     */
    List<Recondite> findReconditeById(Recondite recondite, User user) throws Exception;

    Integer getHomeById(Integer id) throws Exception;
}
