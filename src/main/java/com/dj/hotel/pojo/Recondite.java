package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Recondite记录表
 * @author 杨承雨
 */
@Data
@TableName("recondite")
@Accessors(chain = true)
public class Recondite {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 用户表(user)的id */
    private Integer userId;

    /** 在店日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//接收前台时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回前台格式
    private LocalDateTime startTime;

    /** 房间表(home)的id */
    private Integer homeId;

    /** 状态 */
    private Integer eatStatus;

    /** 离店日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//接收前台时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回前台格式
    private LocalDateTime endTime;

    @TableField("user_name")
    private String userIdShow;

    @TableField("home_name")
    private String homeNameShow;

    @TableField("base_name")
    private String baseNameShow;

}
