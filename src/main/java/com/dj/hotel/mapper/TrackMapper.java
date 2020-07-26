package com.dj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.hotel.pojo.Track;
import com.dj.hotel.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.math.BigDecimal;

import java.util.List;

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

    BigDecimal priceSum() throws DataAccessException;

    /**
     *
     * @Title: findTrackByAll
     * @Description: 展示自己的点餐信息
     * @Date: 2020年7月25日
     * @author: hhq
     * @param: @return
     * @throws
     */
    List<Track> findTrackByAll(@Param("track") Track track, @Param("user") User user) throws DataAccessException;
}
