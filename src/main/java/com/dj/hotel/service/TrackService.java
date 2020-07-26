package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;

/**
 * 记录service
 * @author ck
 */
public interface TrackService extends IService<Track> {

    /**
     *
     * @Title: insertTrackAndReconditeAndMenu
     * @Description: 新增轨迹
     * @Date: 2020年7月26日
     * @author: ck
     * @param: @return
     * @throws
     */
    void insertTrackAndReconditeAndMenu(Track track, User user, Recondite recondite) throws Exception;

}
