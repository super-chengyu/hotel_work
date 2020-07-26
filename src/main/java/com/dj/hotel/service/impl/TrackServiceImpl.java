package com.dj.hotel.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.mapper.MenuMapper;
import com.dj.hotel.mapper.ReconditeMapper;
import com.dj.hotel.mapper.TrackMapper;
import com.dj.hotel.pojo.*;
import com.dj.hotel.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(user.getUserLevel() == 3){
            saveRecondite(8, user.getId());
        } else if(user.getUserLevel() == 4){
            saveRecondite(9, user.getId());
        } else if(user.getUserLevel() == 5){
            saveRecondite(10, user.getId());
        }
        //saveRecondite(recondite.getUserId(), recondite.getHomeId());
        trackMapper.addTrack(track);
    }

    private void saveRecondite(Integer eatStatus, Integer userId) throws Exception {
        Recondite recondite = new Recondite();
        Home home = new Home();
        recondite.setUserId(userId);
        recondite.setStartTime(LocalDateTime.now());
        recondite.setHomeId(home.getId());
        recondite.setEatStatus(eatStatus);
        recondite.setEndTime(LocalDateTime.now());
        reconditeMapper.insertRecondite(recondite);
    }


}
