package com.dj.hotel.web;

import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.ReconditeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;
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
    public ResultModel<Object> showRecondite(Recondite recondite, Integer pageNo, @SessionAttribute User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            PageHelper.startPage(pageNo, SysConstant.RECONDITE_PAGE_SIZE);
            List<Recondite> list = reconditeService.findReconditeById(recondite, user);
            PageInfo<Recondite> pageInfo = new PageInfo<>(list);
            map.put("reconditeList", pageInfo.getList());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<Object>().success(map);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<Object>().error("服务器异常，请稍后重试");
        }
    }


}
