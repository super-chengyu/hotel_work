package com.dj.hotel.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.mapper.ReconditeMapper;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.ReconditeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 点餐记录service的实现类
 * @author 杨承雨
 */
@Service
public class ReconditeServiceImpl extends ServiceImpl<ReconditeMapper, Recondite> implements ReconditeService {

    @Autowired
    private ReconditeMapper reconditeMapper;

    @Override
    public void insertRecondite(Recondite recondite) throws Exception {
        reconditeMapper.insertRecondite(recondite);
    }

    @Override
    public List<Recondite> findReconditeById(Recondite recondite, User user) throws Exception {
        return reconditeMapper.findReconditeById(recondite, user);
    }

    @Override
    public Integer getHomeById(Integer id) throws Exception {
        return reconditeMapper.getHomeById(id);
    }

}
