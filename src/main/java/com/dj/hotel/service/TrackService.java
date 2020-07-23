package com.dj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;

/**
 * 记录service
 * @author ck
 */
public interface TrackService extends IService<Track> {

    void addTrackAndMenu(Track track) throws Exception;

}
