package com.dj.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.mapper.ReconditeMapper;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.service.ReconditeService;
import org.springframework.stereotype.Service;

/**
 * 点餐记录service的实现类
 * @author 杨承雨
 */
@Service
public class ReconditeServiceImpl extends ServiceImpl<ReconditeMapper, Recondite> implements ReconditeService {
}
