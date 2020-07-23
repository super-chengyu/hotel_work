package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Recondite记录表
 */
@Data
@TableName("recondite")
public class Recondite {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 用户表(user)的id */
    private Integer userId;

    /** 在店日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//接收前台时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回前台格式
    private Date startTime;

    /** 房间表(home)的id */
    private Integer homeId;

    /** 状态 */
    private Integer eatStatus;

    /** 离店日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//接收前台时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回前台格式
    private Date endTime;

}
