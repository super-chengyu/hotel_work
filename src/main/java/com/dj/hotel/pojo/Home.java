package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Home房间表
 * @author 杨承雨
 */
@Data
@TableName("home")
@Accessors(chain = true)
public class Home {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 房间名 */
    private String homeName;

    /** 房间状态（有无预约 0:无预约，1:已预约） */
    private Integer homeStatus;

    /** 是否为会员房间 0：是，1：不是 */
    private Integer isVip;

    /** 伪删除0：正常，1：删除 */
    private Integer isDel;


}
