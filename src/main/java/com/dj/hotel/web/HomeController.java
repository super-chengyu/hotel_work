package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.Home;
import com.dj.hotel.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * home的控制层
 * @author 杨承雨
 */
@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("showHome")
    public ResultModel<Object> showHome(Home home, Integer pageNo){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<Home> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            IPage<Home> page = new Page<>(pageNo, SysConstant.HOME_PAGE_SIZE);
            IPage<Home> pageInfo = homeService.page(page, queryWrapper);
            map.put("homeList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }
}
