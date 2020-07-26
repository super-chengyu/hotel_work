package com.dj.hotel.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.mapper.MenuMapper;
import com.dj.hotel.mapper.ReconditeMapper;
import com.dj.hotel.mapper.TrackMapper;
import com.dj.hotel.pojo.Menu;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 记录表service的impl
 * @author ck
 */
@Service
public class TrackServiceImpl extends ServiceImpl<TrackMapper, Track> implements TrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private ReconditeMapper reconditeMapper;

    @Autowired
    private MenuMapper menuMapper;

/*    @Override
    public void addTrackAndMenu(Track track) throws Exception {
        Menu menu = menuMapper.findMenuByMid(track.getMenuId());
        trackMapper.addTrack(track);
    }*/

    @Override
    public void insertTrackAndReconditeAndMenu(Track track, User user, Recondite recondite) throws Exception {
        Menu menu = menuMapper.findMenuByMid(track.getMenuId());
        saveRecondite(recondite.getUserId(), recondite.getHomeId(), track.getRecoId());
        trackMapper.addTrack(track);
    }

    @Override
    public BigDecimal priceSum() throws Exception {
        return trackMapper.priceSum();
    }

    private void saveRecondite(Integer userId, Integer homeId, Integer id) throws Exception {
        Recondite recondite = new Recondite();
        Track track = new Track();
        recondite.setUserId(userId);
        recondite.setStartTime(LocalDateTime.now());
        recondite.setHomeId(homeId);
        track.setRecoId(id);
        recondite.setEndTime(LocalDateTime.now());
        reconditeMapper.insertRecondite(recondite);
    }


}
