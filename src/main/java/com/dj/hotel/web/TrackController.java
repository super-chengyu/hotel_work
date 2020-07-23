package com.dj.hotel.web;

import com.dj.hotel.common.ResultModel;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.MenuService;
import com.dj.hotel.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    public ResultModel<Object> addTrack(Track track, Double menuPrice, @SessionAttribute User user){
        try {
            track.setMenuPrice(track.getMenuNum()*menuPrice);
            trackService.addTrackAndMenu(track);
            return new ResultModel<>().success("订单提交成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<Object>().error("服务器异常");
        }
    }

}
