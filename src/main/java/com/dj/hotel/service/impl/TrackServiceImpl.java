package com.dj.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.mapper.MenuMapper;
import com.dj.hotel.mapper.TrackMapper;
import com.dj.hotel.pojo.Menu;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 记录表service的impl
 * @author ck
 */
@Service
public class TrackServiceImpl extends ServiceImpl<TrackMapper, Track> implements TrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void addTrackAndMenu(Track track) throws Exception {
        Menu menu = menuMapper.findMenuByMid(track.getMenuId());
        trackMapper.addTrack(track);

    }

}
