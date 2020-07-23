package com.dj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.hotel.pojo.Track;
import org.springframework.dao.DataAccessException;

/**
 * 记录表mapper
 * @author ck
 */
public interface TrackMapper  extends BaseMapper<Track> {

    /**
     *
     * @Title: addTrack
     * @Description: 新增轨迹
     * @Date: 2020年7月23日
     * @author: ck
     * @param: @return
     * @throws
     */
    void addTrack(Track track) throws DataAccessException;
}
