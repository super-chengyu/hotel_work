package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;

import java.util.List;

import java.math.BigDecimal;

/**
 * 记录service
 * @author ck
 */
public interface TrackService extends IService<Track> {

    /**
     *
     * @Title: addTrack
     * @Description: 新增轨迹
     * @Date: 2020年7月24日
     * @author: ck
     * @param: @return
     * @throws
     */
    //void addTrackAndMenu(Track track) throws Exception;

    void insertTrackAndReconditeAndMenu(Track track, User user, Recondite recondite) throws Exception;

    /**
     *
     * @Title: findTrackByAll
     * @Description: 展示自己的点餐信息
     * @Date: 2020年7月25日
     * @author: hhq
     * @param: @return
     * @throws
     */
    List<Track> findTrackByAll(Track track,  User user) throws Exception;
    BigDecimal priceSum() throws Exception;

}
