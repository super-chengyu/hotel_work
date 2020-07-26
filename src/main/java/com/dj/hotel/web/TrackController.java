package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.pojo.*;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.service.MenuService;
import com.dj.hotel.service.TrackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记录页面控制层
 * @author ck
 */
@RestController
@RequestMapping("/track/")
public class TrackController {

    @Autowired
    private TrackService trackService;

    /**
     *
     * @Title: addTrack
     * @Description: 新增轨迹
     * @Date: 2020年7月23日
     * @author: ck
     * @param: @return
     * @throws
     */
    @RequestMapping("addTrack")
    public ResultModel<Object> addTrack(Track track, Double menuPrice, @SessionAttribute User user,
                                        Integer id, Recondite recondite){
        try {
            track.setMenuPrice(track.getMenuNum()*menuPrice);
            trackService.insertTrackAndReconditeAndMenu(track, user, recondite);
            return new ResultModel<>().success("订单提交成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<Object>().error("服务器异常");
        }
    }

    /**
     *
     * @Title: showTrack
     * @Description: 查看自己的点餐信息展示
     * @Date: 2020年7月25日
     * @author: hhq
     * @param: @param track, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("showTrack")
    public ResultModel<Object> showTrack(Track track, @SessionAttribute("user") User user, Integer pageNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //QueryWrapper<Recondite> queryWrapper = new QueryWrapper<>();
            PageHelper.startPage(pageNo, 5);
            //queryWrapper.eq("eat_status", 10);
            List<Track> list = trackService.findTrackByAll(track, user);
            //reconditeService.page(page, queryWrapper);
            PageInfo<Track> pageInfo = new PageInfo<>(list);
            map.put("trackList", pageInfo.getList());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<Object>().success(map);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<Object>().error("服务器异常，请稍后重试");
        }
    }

}
