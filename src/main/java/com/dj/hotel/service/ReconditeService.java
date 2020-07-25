package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Recondite;
import org.springframework.dao.DataAccessException;


/**
 * 点餐记录service接口
 * @author 杨承雨
 */
public interface ReconditeService extends IService<Recondite> {

    void insertRecondite(Recondite recondite) throws Exception;
}
