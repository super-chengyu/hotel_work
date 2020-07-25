package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.Home;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.service.ReconditeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 点餐记录Controller
 * @author 杨承雨
 */

@RestController
@RequestMapping("/recondite/")
public class ReconditeController {

    @Autowired
    private ReconditeService reconditeService;

    /**
     *
     * @Title: showRecondite
     * @Description: 已完成订单查询
     * @Date: 2020年7月25日
     * @author: ck
     * @param: @param home, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("showRecondite")
    public ResultModel<Object> showRecondite(Recondite recondite, Integer pageNo){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<Recondite> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("eat_status", 10);
            IPage<Recondite> page = new Page<>(pageNo, SysConstant.HOME_PAGE_SIZE);
            IPage<Recondite> pageInfo = reconditeService.page(page, queryWrapper);
            map.put("reconditeList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

}
